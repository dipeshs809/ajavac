import syntaxtree.*;
import visitor.*;

import java.util.*;

import javax.xml.transform.Source;

public class Main {
   public static HashMap<Node, Set<String>> resultMap;
   public static HashMap<Node, HashMap<String, HashSet<String>>> graphMap = new HashMap<Node, HashMap<String, HashSet<String>>>();
   public static Map<String, Integer> registers = new HashMap<String, Integer>();
   public static HashMap<Node, HashMap<String, String>> metaData = new HashMap<Node, HashMap<String, String>>();
   public static HashMap<Node, HashMap<String, String>> methodParams = new HashMap<Node, HashMap<String, String>>();
   public static ArrayList<String> progOutput = new ArrayList<String>();
   public static void main(String [] args) {
      try {

         Node root = new FriendTJ(System.in).Goal();
         CFGGen cfgGen = new CFGGen();
         root.accept(cfgGen);

         ProgramCFG programCFG = cfgGen.getCFG();

         RunAnalysis ra = new RunAnalysis(programCFG);
         ra.startAnalysisBackward();

         // Assignment Starts here
         // Result Map contains a mapping from statements to live variables at that statement
         resultMap = ra.getResultMap();
         root.accept(new MetaData(metaData, methodParams));
         root.accept(new GraphGen(resultMap, graphMap, registers, methodParams));
         root.accept(new OutputGen(graphMap, methodParams, registers.get("r"), metaData, progOutput));
         for(String line: progOutput){
            System.out.println(line);
         }
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
}
