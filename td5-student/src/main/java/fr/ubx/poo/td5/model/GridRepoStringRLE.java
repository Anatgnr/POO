package fr.ubx.poo.td5.model;

public class GridRepoStringRLE implements GridRepo{

    final char EOL = 'x';
    @Override
    public Grid load(String string) {
        Grid g;
        char a;
        char b;
        char c;
        //String s = "";
        int countlines = 0;
        int cpt = 0;
        int compteursave = 0;
        while(cpt != string.length())
        {
            a = string.charAt(cpt);
            if (a == EOL)
            {
                countlines ++;
            }
            if(a == EOL && compteursave == 0)
            {
                countlines++;
                compteursave = cpt;
            }
            cpt ++;
        }
        int countcharperlines = 0;//(string.length() - countlines)/countlines;
        int test = 0;
        System.out.print("compteur save : " + compteursave + "\n");
        for(int y = 0; y < compteursave ; y++)
        {
            a = string.charAt(y);
            if(y < string.length() - 1) {
                c = string.charAt(y+1);
                System.out.print("c : " + c + "\n");
            }
            else
            {
                c = 125;
            }
            if(a > 57 && c > 57)
            {
                test++;
            }
            else if(a > 30 && a <= 57)
            {
                b = string.charAt(y);
                test += Character.getNumericValue(b);
            }
        }
        countcharperlines = test;
        System.out.print("cpt : " + test + " count : " + countcharperlines + "\n");
        g = new Grid(countcharperlines,countlines);
        int cpt2 = 0;
        int cpt3 = 1;
        int i = 0;
        for(int j = 0; j < string.length(); j++)
        {
            a = string.charAt(j);
            //System.out.print("j : " + j + " length : " + string.length() + "\n") ;
            if(j < string.length() - 1) {
                c = string.charAt(j+1);
                //System.out.print("c : " + c + "\n");
            }
            else
            {
                c = 125;
            }
            // System.out.println(a);
            if (a == EOL)
            {
                i++;
                // count the number of lines
                cpt2 = 0;
                // count the number of char ea ch times we have a new line
            }
            else if(a > 30 && a <= 57)
            {
                //System.out.print("WOOP\n");
                b = string.charAt(j-1);
                //System.out.print("b : " + b + " a numeric : " + a + "\n");
                for(int k = 0 ; k < Character.getNumericValue(a); k++)
                {
                    switch(b)
                    {
                        case 'G':
                            g.set(cpt2,i,Entity.GROUND);
                            cpt2++;
                            break;
                        case 'D':
                            g.set(cpt2,i,Entity.DUST);
                            cpt2++;
                            break;
                        case 'R':
                            g.set(cpt2,i,Entity.ROCK);
                            cpt2++;
                            break;
                        case 'B':
                            g.set(cpt2,i,Entity.BIGROCK);
                            cpt2++;
                            break;
                        case 'C':
                            g.set(cpt2,i,Entity.CRACK);
                            cpt2++;
                            break;
                    }
                }

            }
            else if(a > 57 && c > 57)
            {
                //System.out.printf("RRRRx -> ok : " + a + c + "\n");
                switch(a)
                {
                    case 'G':
                        g.set(cpt2,i,Entity.GROUND);
                        cpt2++;
                        break;
                    case 'D':
                        g.set(cpt2,i,Entity.DUST);
                        cpt2++;
                        break;
                    case 'R':
                        g.set(cpt2,i,Entity.ROCK);
                        cpt2++;
                        break;
                    case 'B':
                        g.set(cpt2,i,Entity.BIGROCK);
                        cpt2++;
                        break;
                    case 'C':
                        g.set(cpt2,i,Entity.CRACK);
                        cpt2++;
                        break;
                }
            }

        }
        return g;

    }

    @Override
    public String export(Grid grid) {
        String s = "";
        int cpt = 1;
        boolean test = false;
        System.out.print("Taille : " + grid.getWidth() + "\n") ;
        for(int i = 0; i< grid.getHeight();i++) {

            for (int j = 0; j < grid.getWidth(); j++) {
                System.out.print( "J : " + j + "\n");

                if(j != grid.getWidth()-1)
                {
                    if(grid.get(j+1,i) == grid.get(j,i) )
                    {
                        cpt ++;
                        //System.out.print("compteur : " + cpt + "\n");
                    }
                    else if(grid.get(j+1,i) != grid.get(j,i) )
                    {
                        test = true;

                        //System.out.print("first true : " + grid.get(j-1, i) + cpt +"\n");
                    }
                }
                else if(j == grid.getWidth() -1)
                {
                    if(grid.get(j,i) == grid.get(j-1,i) && cpt == 1)
                    {
                        cpt++;

                    }
                    test = true;
                }

                if(test) {
                    switch (grid.get(j, i)) {
                        case ROCK:
                            s += 'R';
                            if(cpt > 1) {
                                s += Integer.toString(cpt);
                                cpt = 1;
                            }
                            test = false;
                            break;
                        case DUST:
                            s += 'D';
                            if(cpt > 1) {
                                s += Integer.toString(cpt);
                                cpt = 1;
                            }
                         test = false;
                            break;
                        case BIGROCK:
                            s += 'B';
                            if(cpt > 1) {
                                s += Integer.toString(cpt);
                                cpt = 1;
                            }
                            test = false;
                            break;
                        case GROUND:
                            s += 'G';
                            if(cpt > 1) {
                                s += Integer.toString(cpt);
                                cpt = 1;
                            }
                            test = false;
                            break;
                        case CRACK:
                            s += 'C';
                            if(cpt > 1) {
                                s += Integer.toString(cpt);
                                cpt = 1;
                            }
                        test = false;
                            break;
                    }
                }




            }
            s+= 'x';
        }
        return s;

    }
}
