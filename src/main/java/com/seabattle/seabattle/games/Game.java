package com.seabattle.seabattle.games;

import org.springframework.stereotype.Component;

@Component
public class Game {

    public int[][] enemys_playing_field = new int[10][10];
    public int[][] playing_field = new int[10][10];

    public int Check (String str)
    {
        int conclusion;

        int i,j;
        i = Character.getNumericValue(str.charAt(0));
        j = Character.getNumericValue(str.charAt(1));

        if (enemys_playing_field[i][j] == 1)
        {
            conclusion = 1;
            return conclusion;
        }
        else{
            conclusion = 0;
            return conclusion;
        }
    }

    public int[][] add_ships()
    {
        for (int ii = 0; ii < 10; ii++){
            for (int jj = 0; jj < 10; jj++){
                playing_field[ii][jj] = 0;
            }
        }

        int[] ships = new int[10];
        ships[0] = 4;
        ships[1] = 3;
        ships[2] = 3;
        ships[3] = 2;
        ships[4] = 2;
        ships[5] = 2;
        ships[6] = 1;
        ships[7] = 1;
        ships[8] = 1;
        ships[9] = 1;

        //System.out.println("РАЗМЕР КОРАБЛЯ: " + ships[0]);


        int length_0 = 0;

        int rand = 0;
        // 1 - 4 палубы
        // 2 - 3 палубы
        // 3 - 2 палубы
        // 4 - 1 палубы
        //генерация четырехпалубного корабля
        //int random_direction = a + (int) (Math.random() * b);
        //System.out.println("1-ое случайное число: " + random_direction);

        int[] massiv_i = new int[140];
        int[] massiv_j = new int[140];
        int number = 0;

        for (int size = 0; size < 10; size++)
        {


            //int random_direction = 1;
            int random_direction = 1 + (int) (Math.random() * 2);
            //ArrayList<Integer> mass_i = new ArrayList<>();
            //ArrayList<Integer> mass_j = new ArrayList<>();
            number = 0;

            switch (random_direction)
            {
                case (1):
                {
                    for (int random_i = 0; random_i < 10; random_i++)
                    {
                        for (int random_j = 0; random_j < 10; random_j++)
                        {
                            if (random_j >= ships[size])
                            {
                                if (ships[size] == 4)
                                {
                                    if (playing_field[random_i][random_j] == 0 && playing_field[random_i][random_j-1] == 0 && playing_field[random_i][random_j-2] == 0 && playing_field[random_i][random_j-3] == 0)
                                    {
                                        //mass_i.add(random_i);
                                        //mass_j.add(random_j);
                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }
                                if (ships[size] == 3)
                                {
                                    if (playing_field[random_i][random_j] == 0 && playing_field[random_i][random_j-1] == 0 && playing_field[random_i][random_j-2] == 0)
                                    {
                                        // mass_i.add(random_i);
                                        //mass_j.add(random_j);

                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }

                                if (ships[size] == 2)
                                {
                                    if (playing_field[random_i][random_j] == 0 && playing_field[random_i][random_j-1] == 0)
                                    {
                                        //mass_i.add(random_i);
                                        //mass_j.add(random_j);
                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }

                                if (ships[size] == 1)
                                {
                                    if (playing_field[random_i][random_j] == 0)
                                    {
                                        // mass_i.add(random_i);
                                        // mass_j.add(random_j);
                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }

                            }
                        }
                    }

                    rand = length_0 + (int) (Math.random() * (number+1));


                    for (int num = 0; num < ships[size]; num++)
                    {
                        playing_field[massiv_i[rand]][massiv_j[rand] - num] = 1;


                        if(massiv_i[rand] != 0)
                        {
                            playing_field[massiv_i[rand]-1][massiv_j[rand] - num] = 2;
                        }
                        if(massiv_i[rand] != 9)
                        {
                            playing_field[massiv_i[rand]+1][massiv_j[rand]-num] = 2;
                        }
                        if (massiv_j[rand] != 9)
                        {
                            playing_field[massiv_i[rand]][massiv_j[rand]+1] = 2;
                        }
                        if (massiv_j[rand]-(ships[size]-1) != 0)
                        {
                            playing_field[massiv_i[rand]][massiv_j[rand]-ships[size]] = 2;
                        }
                        if(massiv_i[rand] != 0 && massiv_j[rand] != 9)
                        {
                            playing_field[massiv_i[rand]-1][massiv_j[rand]+1] = 2;
                        }
                        if(massiv_i[rand] != 9 && massiv_j[rand] != 9)
                        {
                            playing_field[massiv_i[rand]+1][massiv_j[rand]+1] = 2;
                        }
                        if(massiv_i[rand] != 0 && massiv_j[rand]-(ships[size]-1) != 0)
                        {
                            playing_field[massiv_i[rand]-1][massiv_j[rand]-ships[size]] = 2;
                        }
                        if(massiv_i[rand] != 9 && massiv_j[rand]-(ships[size]-1) != 0)
                        {
                            playing_field[massiv_i[rand]+1][massiv_j[rand]-ships[size]] = 2;
                        }

                    }


                    break;
                }
                case (2):
                {
                    for (int random_j = 0; random_j < 10; random_j++)
                    {
                        for (int random_i = 0; random_i < 10; random_i++)
                        {
                            if (random_i >= ships[size])
                            {
                                if (ships[size] == 4)
                                {
                                    if (playing_field[random_i][random_j] == 0 && playing_field[random_i-1][random_j] == 0 && playing_field[random_i-2][random_j] == 0 && playing_field[random_i-3][random_j] == 0)
                                    {
                                        //mass_i.add(random_i);
                                        //mass_j.add(random_j);
                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }
                                if (ships[size] == 3)
                                {
                                    if (playing_field[random_i][random_j] == 0 && playing_field[random_i-1][random_j] == 0 && playing_field[random_i-2][random_j] == 0)
                                    {
                                        // mass_i.add(random_i);
                                        //mass_j.add(random_j);

                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }

                                if (ships[size] == 2)
                                {
                                    if (playing_field[random_i][random_j] == 0 && playing_field[random_i-1][random_j] == 0)
                                    {
                                        //mass_i.add(random_i);
                                        //mass_j.add(random_j);
                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }

                                if (ships[size] == 1)
                                {
                                    if (playing_field[random_i][random_j] == 0)
                                    {
                                        // mass_i.add(random_i);
                                        // mass_j.add(random_j);
                                        massiv_i[number] = random_i;
                                        massiv_j[number] = random_j;
                                        number++;
                                    }
                                }

                            }
                        }
                    }

                    rand = length_0 + (int) (Math.random() * (number+1));


                    for (int num = 0; num < ships[size]; num++)
                    {
                        playing_field[massiv_i[rand] - num][massiv_j[rand]] = 1;


                        if(massiv_i[rand] != 9)
                        {
                            playing_field[massiv_i[rand]+1][massiv_j[rand]] = 2;
                        }
                        if(massiv_i[rand]-(ships[size]-1) != 0)
                        {
                            playing_field[massiv_i[rand]-ships[size]][massiv_j[rand]] = 2;

                        }
                        if (massiv_j[rand] != 9)
                        {
                            playing_field[massiv_i[rand]-num][massiv_j[rand]+1] = 2;
                        }
                        if (massiv_j[rand] != 0)
                        {
                            playing_field[massiv_i[rand]-num][massiv_j[rand]-1] = 2;
                        }


                        if(massiv_i[rand] != 9 && massiv_j[rand] != 9)
                        {
                            playing_field[massiv_i[rand]+1][massiv_j[rand]+1] = 2;
                        }
                        if(massiv_i[rand] != 9 && massiv_j[rand] != 0)
                        {
                            playing_field[massiv_i[rand]+1][massiv_j[rand]-1] = 2;
                        }
                        if(massiv_i[rand]-(ships[size]-1) != 0 && massiv_j[rand] != 0)
                        {
                            playing_field[massiv_i[rand]-ships[size]][massiv_j[rand]-1] = 2;
                        }
                        if(massiv_i[rand]-(ships[size]-1) != 0 && massiv_j[rand] != 9)
                        {
                            playing_field[massiv_i[rand]-ships[size]][massiv_j[rand]+1] = 2;
                        }

                    }


                    break;
                }

                default:{
                    break;
                }

            }


        }
        return playing_field;
    }





}

