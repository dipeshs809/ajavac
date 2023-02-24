
import java.io.ByteArrayInputStream;

import syntaxtree.*;
import visitor.*;

public class Main {
   public static void main(String [] args) {
      try {
         Node root = new FriendsTJ(System.in).Goal();
         CFGVisitor cfgVisitor = new CFGVisitor();
         root.accept(cfgVisitor, null);
         DemoVisitor demoVisitor = new DemoVisitor(); //This is a demo visitor. You need to construct a similar visitor for this assignment. You may also see CFGVisitor class for more info.
         root.accept(demoVisitor);
      }
      catch (ParseException e) {
         System.out.println(e.toString());
      }
   }
} 
