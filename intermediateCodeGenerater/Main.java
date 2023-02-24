import java.util.*;

import syntaxtree.*;
import visitor.*;

public class Main {
   public static Map<String, Struct> metaData = new HashMap<String, Struct>();
   public static Map<String, Struct> metaDataInherited = new HashMap<String, Struct>();
   public static ArrayList<String> outputProg = new ArrayList<String>();
   public static int getVar(ArrayList<pair> A, String var){
      int ind = -1;
      for(pair p: A){
         if(p.var == var) ind = p.index;
      }
      return ind;
   }
   public static void copyData(String parent, String child){
      if(parent == null) return;
      else copyData(metaData.get(parent).parent, child);
      Struct data = metaDataInherited.get(child);
      data.parent = null;
      data.appendVariables(metaData.get(parent).variables);
      data.appendMethods(metaData.get(parent).methodType, parent);
   }
   public static void genInheritedData(){
      for(String cls: metaData.keySet()){
         if(metaDataInherited.get(cls) == null) metaDataInherited.put(cls, new Struct());
         copyData(cls, cls);
      }
   }
   public static void printmeta(){
      for(String cls: metaData.keySet()){
         System.out.println(cls);
         System.out.println(metaData.get(cls).parent);
         System.out.println(metaData.get(cls).classVariables);
         System.out.println("Methods");
         for(String met: metaData.get(cls).methodType.keySet()){
            pair p = metaData.get(cls).methodType.get(met);
            System.out.println(met + " "+ p.var+ " "+ p.index);
         }
         System.out.println(metaData.get(cls).methodParams);
         System.out.println(metaData.get(cls).methodVariables);
         for(pair p : metaData.get(cls).variables) p.print();
      }
   }
   public static void printmetainher(){
      for(String cls: metaDataInherited.keySet()){
         System.out.println(cls);
         System.out.println(metaDataInherited.get(cls).parent);
         System.out.println("variables");
         for(pair p : metaDataInherited.get(cls).variables) p.print();
         System.out.println("Methods");
         for(String met: metaDataInherited.get(cls).methodType.keySet()){
            pair p = metaDataInherited.get(cls).methodType.get(met);
            System.out.println(met + " "+ p.var+ " "+ p.index);
         }
      }
   }
   public static void printoutput(){
      for(String progLine : outputProg){
         System.out.println(progLine);
      }
   }
   public static void main(String [] args) {
      try {
         Node root = new TempoJavaParser(System.in).Goal();
         // System.out.println("Program parsed successfully");
         HashMap<String, String> argu = new HashMap<String, String>() ;
         root.accept(new metaDataGen(), argu); // Your assignment part is invoked here.
         genInheritedData();
         outputProg.add("package cs502;");
         outputProg.add("import static cs502.memmgr.MemMgr.*;");
         outputProg.add("public class Main {");
         root.accept(new outputGen(), argu); // Your assignment part is invoked here.
         outputProg.add("}");
         // printmeta();
         // printmetainher();
         printoutput();
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
