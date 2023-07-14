//Ikaia Melton
//Theoretical Foundation Project


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DFA {

    public static void main(String[] args) throws IOException {

        FileReader fr=new FileReader(args[0]);// file for opening
        BufferedReader br=new BufferedReader(fr);// BufferedReader applied on FileReader object
        Scanner sc=new Scanner(System.in); // Scanner object for reading from console
        String alphabet=br.readLine(); // reads alphabet from file
        String states=br.readLine();// reads states from file
        String startState=br.readLine();// reads start state from file
        String acceptStates=br.readLine(); // reads accept states from file

        /*Displays alphabet, states,start state and accept states*/
        System.out.println("Alphabet: "+alphabet);
        System.out.println("States: "+states);
        System.out.println("Start state: "+startState);
        System.out.println("Accept States: "+acceptStates);
        String str="",s;

        /*reads rules from file and concatenates them with a # symbol*/
        while((s=br.readLine())!=null)
            str=str+s+"#";
//                System.out.println(str + " HERE");
        String rules[]=str.split("#");/* splits the rules at # symbol to form an array of rules*/
        System.out.println("Transition rules are:");// displays rules
        for(String rule: rules) {
            System.out.println(rule);
        }

        HashMap<String, List<String[]>> map = new HashMap<>();

//        (Banana,0)->Banana
//                (Banana,1)->Pudding
//                (Pudding,0)->Banana
//                (Pudding,1)->Pudding

        for(String line: rules){
            String start = line.substring(1, line.indexOf(","));
            String finish = line.substring(line.indexOf(">")+1);
            String number = line.substring(line.indexOf(",")+1, line.indexOf(",")+2);

            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(new String[]{number, finish});
        }

        

        System.out.println("Enter the string for testing:");
        String testString=sc.next();// reads a string from console for testing

        String currentState = startState;

        currentState = makeTransitions(map, testString, currentState);


        if(acceptStates.contains(currentState)){
        	
            System.out.println("String accepted!");
        } else{
            System.out.println("String not accepted.");
        }
    }

    private static String makeTransitions(HashMap<String, List<String[]>> map, String testString, String currentState) {
        for(char state: testString.toCharArray()){
            List<String[]> tempList = map.get(currentState);

            for(String[] temp: tempList){
                if(temp[0].equals(Character.toString(state))){
                    currentState = temp[1];
                }
            }
        }
        return currentState;
    }

  
}
