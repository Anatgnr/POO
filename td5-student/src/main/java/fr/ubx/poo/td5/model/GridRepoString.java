package fr.ubx.poo.td5.model;

public class GridRepoString implements GridRepo{
    final char EOL = 'x';

    @Override
    public Grid load(String string) {
        Grid g;
        char a;

        int countlines = 0;
        // count nblibnes in the string passed as an argument
        int cpt = 0;
        while(cpt != string.length())
        {
            a = string.charAt(cpt);
            if (a == EOL)
                countlines ++;
            cpt ++;
        }
        // Ok jusque LA

        System.out.println("nblines " + countlines +" strl " + string.length());

        int countcharperlines = (string.length() - countlines)/countlines;
        System.out.println("char par lignes = " + countcharperlines);
        // Ok

        // nbcases = nbx ## nbchar\x = nbchar - nbx donc ## nbchar/cases = nbchar\x / nbx ##
        g = new Grid(countcharperlines,countlines);
        // initialising the grid to return
        int cpt2 = 0;
        int i = 0;
        for(int j = 0; j < string.length(); j++)
        {
            a = string.charAt(j);
            if (a == EOL)
            {
                i++;
                // count the number of lines
                cpt2 = 0;
                // count the number of char ea ch times we have a new line
            }
            else
            {
                switch(a)
                {
                    case 'G':
                        g.set(cpt2,i,Entity.GROUND);
                    case 'D':
                        g.set(cpt2,i,Entity.DUST);
                    case 'R':
                        g.set(cpt2,i,Entity.ROCK);
                    case 'B':
                        g.set(cpt2,i,Entity.BIGROCK);
                    case 'C':
                        g.set(cpt2,i,Entity.CRACK);
                }
            }
            cpt2 ++;
        }
        return g;
    }

    @Override
    public String export(Grid grid) {
        return null;
    }
}
