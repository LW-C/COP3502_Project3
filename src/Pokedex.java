import java.util.*;

public class Pokedex
{
    private Pokemon[] pokemons;

    public Pokedex(int num)
    {
        pokemons = new Pokemon[num];
    }

    /*
     *  Return all the names of the Pokemon species in the
     *  Pokedex.
     */
    public String[] listPokemon()
    {
        String[] names;
        int a = 0;
        int indexA = 0;

        for(indexA = 0; indexA <= pokemons.length; indexA++)
        {
            if(indexA == pokemons.length)
            {
                a = indexA;
            }
            else if (pokemons[indexA] == null)
            {
                a = indexA;
                break;
            }
        }

        names = new String[a];

        for(int index = 0; index < a; index++)
        {
            names[index] = pokemons[index].getSpecies();
        }
        return names;
    }

    /*
     *  Add a Pokemon to the Pokedex and return true if it can
     *  actually be added to the Pokedex. If not, return false.
     */
    public boolean addPokemon(String species)
    {
        if (pokemons[pokemons.length - 1] != null)
        {
            System.out.println("Max");

            for(int index = 0; index < pokemons.length; index++)
            {
                if ((pokemons[index] != null) && (species.equalsIgnoreCase(pokemons[index].getSpecies())))
                {
                    System.out.println("Duplicate");
                    return false;
                }
            }

            return false;
        }

        for(int index = 0; index < pokemons.length; index++)
        {
            if ((pokemons[index] != null) && (species.equalsIgnoreCase(pokemons[index].getSpecies())))
            {
                System.out.println("Duplicate");
                return false;
            }
        }

        for(int index = 0; index < pokemons.length; index++)
        {
            if (pokemons[index] == null)
            {
                pokemons[index] = new Pokemon(species);
                return true;
            }
        }

        return true;
    }

    /*
     *  Return the stats of a certain Pokemon that you are
     *  searching for.
     */
    public int[] checkStats(String species)
    {
        int[] stats = new int[3];
        boolean boo = false;
        int num = 0;

        for(int index = 0; index < pokemons.length; index++)
        {
            if ((pokemons[index] != null) && (species.equalsIgnoreCase(pokemons[index].getSpecies())))
            {
                num = index;
                boo = true;
            }
        }

        if (boo)
        {
            stats[0] = pokemons[num].getAttack();
            stats[1] = pokemons[num].getDefense();
            stats[2] = pokemons[num].getSpeed();
            return stats;
        }
        else
        {
            stats[0] = -1;
            stats[1] = -1;
            stats[2] = -1;
            return stats;
        }

    }

    /*
     * Sort Pokedex in alphabetical order.
     */
    public void sortPokedex()
    {
        String[] names = sortNames();

        Pokemon[] pokemons1 = new Pokemon[pokemons.length];

        //creating a copy of the array to iterate through
        for (int a = 0; a < pokemons.length; a++)
        {
            pokemons1[a] = pokemons[a];
        }

        //putting the Pokemon in order
        for (int b = 0; b < names.length; b++)
        {
            for(int c = 0; c < pokemons1.length; c++)
            {
                if(pokemons1[c] == null)
                    break;
                else if (names[b].equals(pokemons1[c].getSpecies()))
                {
                    pokemons[b] = pokemons1[c];
                    break;
                }
            }
        }
    }


    public String[] sortNames()
    {
        String[] names = listPokemon();
        ArrayList<String> names1 = new ArrayList<String>();

        for(int a = 0; a < names.length; a++)
        {
            int b = 0;
            for (int c = 0; c <= names1.size() && c < names.length; c++)
            {
                if(a == 0)
                {
                    names1.add(names[a]);
                    break;
                }
                else
                {
                    b = names[a].compareTo(names1.get(c));

                    if (b < 0)
                    {
                        //this name belongs in the ArrayList before the one it's being compared to
                        names1.add(c, names[a]);
                        break;
                    }
                    else if (b == 0)
                    {
                        //this case shouldn't happen because the program doesn't allow for duplicates
                    }
                    else if ((b > 0) && (c == (names1.size() - 1)))
                    {
                        //the name in question belongs after the name already in the ArrayList
                        names1.add(names[a]);
                        break;
                    }
                }
            }
        }
        return names1.toArray(new String[names1.size()]);
    }


    /*
     *  Evolve a certain Pokemon that you are searching for in the
     *  Pokedex and return true if the Pokemon is actually in
     *  the Pokedex. If not, return false.
     */
    public boolean evolvePokemon(String species)
    {
        boolean boo = false;
        int num = -1;

        for(int index = 0; index < pokemons.length; index++)
        {
            if ((pokemons[index] != null) && (species.equalsIgnoreCase(pokemons[index].getSpecies())))
            {
                num = index;
                boo = true;
            }
        }

        if (boo)
        {
            pokemons[num].evolve();
            System.out.println(pokemons[num].getSpecies() + " has evolved!");
        }

        return boo;
    }
}
