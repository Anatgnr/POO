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

        //System.out.println("nblines " + countlines +" strl " + string.length());

        int countcharperlines = (string.length() - countlines)/countlines;
        //System.out.println("char par lignes = " + countcharperlines);
        // Ok

        // nbcases = nbx ## nbchar\x = nbchar - nbx donc ## nbchar/cases = nbchar\x / nbx ##
        g = new Grid(countcharperlines,countlines);
        // initialising the grid to return
        int cpt2 = 0;
        int i = 0;
        for(int j = 0; j < string.length(); j++)
        {
            a = string.charAt(j);
            // System.out.println(a);
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
                        break;
                    case 'D':
                        g.set(cpt2,i,Entity.DUST);
                        break;
                    case 'R':
                        g.set(cpt2,i,Entity.ROCK);
                        break;
                    case 'B':
                        g.set(cpt2,i,Entity.BIGROCK);
                        break;
                    case 'C':
                        g.set(cpt2,i,Entity.CRACK);
                        break;
                }
                cpt2 ++;
            }
        }
        return g;
    }

    @Override
    public String export(Grid grid) {
        String s = "";
        for(int i = 0; i< grid.getHeight();i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                // System.out.println("sout : " + grid.get(j, i));
                switch(grid.get(j, i)){
                    case ROCK:
                        s+='R';
                        break;
                    case DUST:
                        s+='D';
                        break;
                    case BIGROCK:
                        s+='B';
                        break;
                    case GROUND:
                        s+='G';
                        break;
                    case CRACK:
                        s+='C';
                        break;
                }
            }
            s+= 'x';
        }
        return s;
        // OK
    }
}
