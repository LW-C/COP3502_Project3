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
        names = new String[pokemons.length];

        for(int index = 0; index > pokemons.length; index++)
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
        //Use a sort method from project 2???
        String[] names = listPokemon();
        Arrays.sort(names);
        Pokemon[] pokemons1 = new Pokemon[pokemons.length];

        for (int a = 0; a < pokemons.length; a++)
        {
            pokemons1[a] = pokemons[a];
        }

        for (int b = 0; b < names.length; b++)
        {
            for(int c = 0; c < pokemons1.length; c++)
            {
                if (names[b].equals(pokemons1[c].getSpecies()))
                {
                    pokemons[b] = pokemons1[c];
                }
            }
        }
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
        }

        return boo;
    }
}
