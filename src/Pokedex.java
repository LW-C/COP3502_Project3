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
        //add info to the array

        return stats;
    }

    /*
     * Sort Pokedex in alphabetical order.
     */
    public void sortPokedex()
    {
        //Use a sort method from project 2???
    }

    /*
     *  Evolve a certain Pokemon that you are searching for in the
     *  Pokedex and return true if the Pokemon is actually in
     *  the Pokedex. If not, return false.
     */
    public boolean evolvePokemon(String species)
    {
        boolean boo = false;
        //carry out the instructions

        return boo;
    }
}
