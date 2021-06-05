package com.seabattle.games;

import org.springframework.stereotype.Component;


@Component
public class Game {
    public int[][] playing_field_1 = new int[10][10];
    public int[][] playing_field_2 = new int[10][10];
    public int motion_check = 0;
    public int[] playing_id = new int[2];
    public int score_1 = 0;
    public int score_2 = 0;

    //    public void Restart()
//    {
//        this.playing_id[0] = 0;
//        this.playing_id[1] = 0;
//
//    }

    public int Check(String str) {
        if (Character.getNumericValue(str.charAt(0)) == 2)
        {
            int conclusion_1;

            int i, j;
            i = Character.getNumericValue(str.charAt(1));
            j = Character.getNumericValue(str.charAt(2));

            if (playing_field_1[i][j] == 1) {
                conclusion_1 = 1;
                playing_field_1[i][j] = 11;
                return conclusion_1;
            } else {
                conclusion_1 = 0;
                playing_field_1[i][j] = 10;
                return conclusion_1;
            }
        }
        else
        {
            int conclusion_2;

            int i, j;
            i = Character.getNumericValue(str.charAt(1));
            j = Character.getNumericValue(str.charAt(2));

            if (playing_field_2[i][j] == 1) {
                conclusion_2 = 1;
                playing_field_2[i][j] = 11;
                return conclusion_2;
            } else {
                conclusion_2 = 0;
                playing_field_2[i][j] = 10;
                return conclusion_2;
            }
        }

    }


    public int[][] Cheking(int id){
        int mass[][] = new int[10][10];
        if (id == 1)
        {

            for (var i = 0; i < 10; i++) {
                for (var j = 0; j < 10; j++) {
                    mass[i][j] = playing_field_1[i][j];
                }
            }
        }
        else if (id == 2)
        {
            for (var i = 0; i < 10; i++) {
                for (var j = 0; j < 10; j++) {
                    mass[i][j] = playing_field_2[i][j];
                }
            }
        }
        return mass;
    }

    public int Chek_id()
    {
        int i = 0;
        if (playing_id[1] == 2222) {
            i = 2;
        }
        else if (playing_id[0] == 1111)
        {
            i = 1;
        }

        return i;
    }


    public int[] Id_gamers(int id) {
        if (id == 1) {
            if (playing_id[0] == 0) {
                playing_id[0] = 1111;
            } else if (playing_id[0] == 1111) {
                playing_id[1] = 2222;
            }
        }


        return playing_id;
    }

    public int Game_Start(int id) {
        int var = 0;
        if (playing_id[0] == 1111) {
            playing_id[0] = 4444;
            var = 1;
            return var;
        } else {
            var = 2;
            return var;
        }


    }

    public int Motion(int motion) {

        if (motion != motion_check)
        {
            motion = motion_check;
        }

        return motion;
    }

    public int Motion_Update(int motion) {

        motion_check = motion;


        return motion_check;
    }

    public int Winner(int score) {

        int win = 0;

        if (score == 11111111)
        {
            score_1++;
            if (score_1==20)
            {
                win = 1;
            }

        }
        else if (score == 2222222)
        {
            score_2++;
            if (score_2==20)
            {
                win = 2;
            }

        }

        return win;
    }



    public int[][] add_ships(int id) {
        if (id == 1) {

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

            for (int size = 0; size < 10; size++) {


                //int random_direction = 1;
                int random_direction = 1 + (int) (Math.random() * 2);
                //ArrayList<Integer> mass_i = new ArrayList<>();
                //ArrayList<Integer> mass_j = new ArrayList<>();
                number = 0;

                switch (random_direction) {
                    case (1): {
                        for (int random_i = 0; random_i < 10; random_i++) {
                            for (int random_j = 0; random_j < 10; random_j++) {
                                if (random_j >= ships[size]) {
                                    if (ships[size] == 4) {
                                        if (playing_field_1[random_i][random_j] == 0 && playing_field_1[random_i][random_j - 1] == 0 && playing_field_1[random_i][random_j - 2] == 0 && playing_field_1[random_i][random_j - 3] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }
                                    if (ships[size] == 3) {
                                        if (playing_field_1[random_i][random_j] == 0 && playing_field_1[random_i][random_j - 1] == 0 && playing_field_1[random_i][random_j - 2] == 0) {
                                            // mass_i.add(random_i);
                                            //mass_j.add(random_j);

                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 2) {
                                        if (playing_field_1[random_i][random_j] == 0 && playing_field_1[random_i][random_j - 1] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 1) {
                                        if (playing_field_1[random_i][random_j] == 0) {
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

                        rand = length_0 + (int) (Math.random() * (number + 1));


                        for (int num = 0; num < ships[size]; num++) {
                            playing_field_1[massiv_i[rand]][massiv_j[rand] - num] = 1;


                            if (massiv_i[rand] != 0) {
                                playing_field_1[massiv_i[rand] - 1][massiv_j[rand] - num] = 2;
                            }
                            if (massiv_i[rand] != 9) {
                                playing_field_1[massiv_i[rand] + 1][massiv_j[rand] - num] = 2;
                            }
                            if (massiv_j[rand] != 9) {
                                playing_field_1[massiv_i[rand]][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_j[rand] - (ships[size] - 1) != 0) {
                                playing_field_1[massiv_i[rand]][massiv_j[rand] - ships[size]] = 2;
                            }
                            if (massiv_i[rand] != 0 && massiv_j[rand] != 9) {
                                playing_field_1[massiv_i[rand] - 1][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_i[rand] != 9 && massiv_j[rand] != 9) {
                                playing_field_1[massiv_i[rand] + 1][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_i[rand] != 0 && massiv_j[rand] - (ships[size] - 1) != 0) {
                                playing_field_1[massiv_i[rand] - 1][massiv_j[rand] - ships[size]] = 2;
                            }
                            if (massiv_i[rand] != 9 && massiv_j[rand] - (ships[size] - 1) != 0) {
                                playing_field_1[massiv_i[rand] + 1][massiv_j[rand] - ships[size]] = 2;
                            }

                        }


                        break;
                    }
                    case (2): {
                        for (int random_j = 0; random_j < 10; random_j++) {
                            for (int random_i = 0; random_i < 10; random_i++) {
                                if (random_i >= ships[size]) {
                                    if (ships[size] == 4) {
                                        if (playing_field_1[random_i][random_j] == 0 && playing_field_1[random_i - 1][random_j] == 0 && playing_field_1[random_i - 2][random_j] == 0 && playing_field_1[random_i - 3][random_j] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }
                                    if (ships[size] == 3) {
                                        if (playing_field_1[random_i][random_j] == 0 && playing_field_1[random_i - 1][random_j] == 0 && playing_field_1[random_i - 2][random_j] == 0) {
                                            // mass_i.add(random_i);
                                            //mass_j.add(random_j);

                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 2) {
                                        if (playing_field_1[random_i][random_j] == 0 && playing_field_1[random_i - 1][random_j] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 1) {
                                        if (playing_field_1[random_i][random_j] == 0) {
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

                        rand = length_0 + (int) (Math.random() * (number + 1));


                        for (int num = 0; num < ships[size]; num++) {
                            playing_field_1[massiv_i[rand] - num][massiv_j[rand]] = 1;


                            if (massiv_i[rand] != 9) {
                                playing_field_1[massiv_i[rand] + 1][massiv_j[rand]] = 2;
                            }
                            if (massiv_i[rand] - (ships[size] - 1) != 0) {
                                playing_field_1[massiv_i[rand] - ships[size]][massiv_j[rand]] = 2;

                            }
                            if (massiv_j[rand] != 9) {
                                playing_field_1[massiv_i[rand] - num][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_j[rand] != 0) {
                                playing_field_1[massiv_i[rand] - num][massiv_j[rand] - 1] = 2;
                            }


                            if (massiv_i[rand] != 9 && massiv_j[rand] != 9) {
                                playing_field_1[massiv_i[rand] + 1][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_i[rand] != 9 && massiv_j[rand] != 0) {
                                playing_field_1[massiv_i[rand] + 1][massiv_j[rand] - 1] = 2;
                            }
                            if (massiv_i[rand] - (ships[size] - 1) != 0 && massiv_j[rand] != 0) {
                                playing_field_1[massiv_i[rand] - ships[size]][massiv_j[rand] - 1] = 2;
                            }
                            if (massiv_i[rand] - (ships[size] - 1) != 0 && massiv_j[rand] != 9) {
                                playing_field_1[massiv_i[rand] - ships[size]][massiv_j[rand] + 1] = 2;
                            }

                        }


                        break;
                    }

                    default: {
                        break;
                    }

                }


            }
            return playing_field_1;
        }
        else{

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

            for (int size = 0; size < 10; size++) {


                //int random_direction = 1;
                int random_direction = 1 + (int) (Math.random() * 2);
                //ArrayList<Integer> mass_i = new ArrayList<>();
                //ArrayList<Integer> mass_j = new ArrayList<>();
                number = 0;

                switch (random_direction) {
                    case (1): {
                        for (int random_i = 0; random_i < 10; random_i++) {
                            for (int random_j = 0; random_j < 10; random_j++) {
                                if (random_j >= ships[size]) {
                                    if (ships[size] == 4) {
                                        if (playing_field_2[random_i][random_j] == 0 && playing_field_2[random_i][random_j - 1] == 0 && playing_field_2[random_i][random_j - 2] == 0 && playing_field_2[random_i][random_j - 3] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }
                                    if (ships[size] == 3) {
                                        if (playing_field_2[random_i][random_j] == 0 && playing_field_2[random_i][random_j - 1] == 0 && playing_field_2[random_i][random_j - 2] == 0) {
                                            // mass_i.add(random_i);
                                            //mass_j.add(random_j);

                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 2) {
                                        if (playing_field_2[random_i][random_j] == 0 && playing_field_2[random_i][random_j - 1] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 1) {
                                        if (playing_field_2[random_i][random_j] == 0) {
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

                        rand = length_0 + (int) (Math.random() * (number + 1));


                        for (int num = 0; num < ships[size]; num++) {
                            playing_field_2[massiv_i[rand]][massiv_j[rand] - num] = 1;


                            if (massiv_i[rand] != 0) {
                                playing_field_2[massiv_i[rand] - 1][massiv_j[rand] - num] = 2;
                            }
                            if (massiv_i[rand] != 9) {
                                playing_field_2[massiv_i[rand] + 1][massiv_j[rand] - num] = 2;
                            }
                            if (massiv_j[rand] != 9) {
                                playing_field_2[massiv_i[rand]][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_j[rand] - (ships[size] - 1) != 0) {
                                playing_field_2[massiv_i[rand]][massiv_j[rand] - ships[size]] = 2;
                            }
                            if (massiv_i[rand] != 0 && massiv_j[rand] != 9) {
                                playing_field_2[massiv_i[rand] - 1][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_i[rand] != 9 && massiv_j[rand] != 9) {
                                playing_field_2[massiv_i[rand] + 1][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_i[rand] != 0 && massiv_j[rand] - (ships[size] - 1) != 0) {
                                playing_field_2[massiv_i[rand] - 1][massiv_j[rand] - ships[size]] = 2;
                            }
                            if (massiv_i[rand] != 9 && massiv_j[rand] - (ships[size] - 1) != 0) {
                                playing_field_2[massiv_i[rand] + 1][massiv_j[rand] - ships[size]] = 2;
                            }

                        }


                        break;
                    }
                    case (2): {
                        for (int random_j = 0; random_j < 10; random_j++) {
                            for (int random_i = 0; random_i < 10; random_i++) {
                                if (random_i >= ships[size]) {
                                    if (ships[size] == 4) {
                                        if (playing_field_2[random_i][random_j] == 0 && playing_field_2[random_i - 1][random_j] == 0 && playing_field_2[random_i - 2][random_j] == 0 && playing_field_2[random_i - 3][random_j] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }
                                    if (ships[size] == 3) {
                                        if (playing_field_2[random_i][random_j] == 0 && playing_field_2[random_i - 1][random_j] == 0 && playing_field_2[random_i - 2][random_j] == 0) {
                                            // mass_i.add(random_i);
                                            //mass_j.add(random_j);

                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 2) {
                                        if (playing_field_2[random_i][random_j] == 0 && playing_field_2[random_i - 1][random_j] == 0) {
                                            //mass_i.add(random_i);
                                            //mass_j.add(random_j);
                                            massiv_i[number] = random_i;
                                            massiv_j[number] = random_j;
                                            number++;
                                        }
                                    }

                                    if (ships[size] == 1) {
                                        if (playing_field_2[random_i][random_j] == 0) {
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

                        rand = length_0 + (int) (Math.random() * (number + 1));


                        for (int num = 0; num < ships[size]; num++) {
                            playing_field_2[massiv_i[rand] - num][massiv_j[rand]] = 1;


                            if (massiv_i[rand] != 9) {
                                playing_field_2[massiv_i[rand] + 1][massiv_j[rand]] = 2;
                            }
                            if (massiv_i[rand] - (ships[size] - 1) != 0) {
                                playing_field_2[massiv_i[rand] - ships[size]][massiv_j[rand]] = 2;

                            }
                            if (massiv_j[rand] != 9) {
                                playing_field_2[massiv_i[rand] - num][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_j[rand] != 0) {
                                playing_field_2[massiv_i[rand] - num][massiv_j[rand] - 1] = 2;
                            }


                            if (massiv_i[rand] != 9 && massiv_j[rand] != 9) {
                                playing_field_2[massiv_i[rand] + 1][massiv_j[rand] + 1] = 2;
                            }
                            if (massiv_i[rand] != 9 && massiv_j[rand] != 0) {
                                playing_field_2[massiv_i[rand] + 1][massiv_j[rand] - 1] = 2;
                            }
                            if (massiv_i[rand] - (ships[size] - 1) != 0 && massiv_j[rand] != 0) {
                                playing_field_2[massiv_i[rand] - ships[size]][massiv_j[rand] - 1] = 2;
                            }
                            if (massiv_i[rand] - (ships[size] - 1) != 0 && massiv_j[rand] != 9) {
                                playing_field_2[massiv_i[rand] - ships[size]][massiv_j[rand] + 1] = 2;
                            }

                        }


                        break;
                    }

                    default: {
                        break;
                    }

                }


            }
            return playing_field_2;
        }


    }

}

