package fr.ubx.poo.td5.model;

public class GridRepoStringRLE implements GridRepo{

    final char EOL = 'x';
    @Override
    public Grid load(String string) {
        Grid g;
        char a;
        char b;
        char s = "";
        int countlines = 0;
        int cpt = 0;
        while(cpt != string.length())
        {
            a = string.charAt(cpt);
            if (a == EOL)
                countlines ++;
            cpt ++;
        }
        int countcharperlines = (string.length() - countlines)/countlines;
        g = new Grid(countcharperlines,countlines);
        int cpt2 = 0;
        int cpt3 = 1;
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
                if (j != 0)
                {
                    b = string.charAt(j);
                    if(a == b)
                    {
                        cpt3 ++;
                    }
                    else
                    {
                        if(cpt3 == 0)
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
                        }
                        else{
                            cpt3 = 0;
                            s += cpt3;
                        }

                    }
                }
                cpt2 ++;
            }
        }
        return g;
        return g;
    }

    @Override
    public String export(Grid grid) {
        return null;
    }
}
