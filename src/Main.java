public class Main {
    public static void main(String[] args) {

            String stringNumber = "Three hundred thousand five hundred";
            String[] words = stringNumber.split(" ");

            String[] digitNumb = {
                    "One", "Two", "Three", "Four", "Five",
                    "Six", "Seven", "Eight", "Nine", "Ten",
                    "Eleven", "Twelve", "Thirteen", "Fourteen",
                    "Fifteen", "Sixteen", "Seventeen", "Eighteen",
                    "Nineteen", "Twenty", "Thirty", "Forty",
                    "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
            };

        String[] numberSuffixes = {
                "Hundred",
                "Thousand",
                "Millions",
                "Million",
                "Billions",
                "Billion",
                "Trillions",
                "Trillion"
        };

        int[] stringNumb = {
                1, 2, 3, 4, 5, 6, 7, 8, 9,
                10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 30, 40, 50, 60, 70, 80, 90
        };

        long[] stringSuffixes = {
                100, 1000, 1000000, 1000000,
                1000000000, 1000000000,
                1000000000000000, 1000000000000000
        };

            int[] positionArr = new int[words.length];
            boolean found = false;

            for(int i = 0; i < words.length; i++) {
                found=false;

                for (int x = 0; x < numberSuffixes.length; x++) {

                    if (words[i].equalsIgnoreCase(numberSuffixes[x]) && !words[i].equalsIgnoreCase("Hundred")) {
                        positionArr[i] = 1;
                    }

                    else if (words[i].equalsIgnoreCase("Hundred")) {
                        outer:
                        for (int v = i+1; v < words.length; v++) {
                            for (int z = 0; z < numberSuffixes.length; z++) {

                                if (words[v].equalsIgnoreCase(numberSuffixes[z]) && !words[v].equalsIgnoreCase("Hundred")) {
                                    positionArr[v] = 1;
                                    found = true;
                                    break outer;
                                }

                            }
                        }
                        if(!found){
                            positionArr[i] = 1;
                        }

                    }

                }
            }

            for(int i = 0; i<positionArr.length;i++){
                System.out.println(i+1+":"+positionArr[i]);
            }


            int position;
            int numb;
            String varible = "";
            int count = 0;

            for (int i = 0; i < words.length; i++){
                for(int y = 0; y < digitNumb.length; y++){

                    if(words[i].equalsIgnoreCase(digitNumb[y])){
                        count++;
                        if(count<2) {
                            varible += stringNumb[y];
                        }
                        else {
                            int parseNumb = 0;
                            parseNumb = Integer.parseInt(varible);
                            parseNumb += Integer.parseInt(stringNumb[y]);
                            varible = String.valueOf(parseNumb);
                        }
                    }



                }

                for(int x = 0; x < numberSuffixes.length; x++){
                    if(words[i].equalsIgnoreCase(numberSuffixes[x]) && words[i].equalsIgnoreCase("Hundred")){
                        for(i+=1; i < words.length; i++){
                            if(words[i].equals(numberSuffixes) && !words[i].equalsIgnoreCase("Hundred")){
                                position = i;
                                break;
                            }
                            else {

                            }


                        }
                            varible += stringSuffixes[x];
                    }
                    else if(words[i].equalsIgnoreCase(numberSuffixes[x]) ){
                        varible += stringSuffixes[x];
                    }
                }


            }

            System.out.println(varible);

    }
}