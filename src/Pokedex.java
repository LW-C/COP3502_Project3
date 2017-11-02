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
        String[] names = new String[pokemons.length()];
        //Add the name of each Pokemon to the array of names

        return names;
    }

    /*
     *  Add a Pokemon to the Pokedex and return true if it can
     *  actually be added to the Pokedex. If not, return false.
     *  If the Pokemon trying to be added is already in the Pokedex,
     *  then print out "Pokemon already in Pokedex" and return false.
     */
    public boolean addPokemon(String species)
    {
        boolean boo;
        //check all of the conditions

        return boo;
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
        boolean boo;
        //carry out the instructions

        return boo;
    }
}
