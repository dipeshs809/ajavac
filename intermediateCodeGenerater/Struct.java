import java.util.*;

public class Struct{
    String parent;
    LinkedHashMap<String, Integer> classVariables;
    ArrayList<pair> variables;
    LinkedHashMap<String, pair> methodType;
    LinkedHashMap<String, LinkedHashMap<String, String>> methodParams;
    LinkedHashMap<String, LinkedHashMap<String, String>> methodVariables;
    Struct(){
        parent = "";
        classVariables = new LinkedHashMap<String, Integer>();
        variables = new ArrayList<pair>();
        methodType = new LinkedHashMap<String, pair>();
        methodParams = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        methodVariables = new LinkedHashMap<String, LinkedHashMap<String, String>>();
    }
    Struct(Struct s){
        parent = s.parent;
        classVariables = new LinkedHashMap<String, Integer>(s.classVariables);
        variables = new ArrayList<pair>(s.variables);
        methodType = new LinkedHashMap<String, pair>(s.methodType);
        methodParams = new LinkedHashMap<String, LinkedHashMap<String, String>>(s.methodParams);
        methodVariables = new LinkedHashMap<String, LinkedHashMap<String, String>>(s.methodVariables);
    }
    void appendVariables( ArrayList<pair> v){
        int n = variables.size()*4 + 4;
        for(pair p : v){
            variables.add(new pair(p.var, n));
            n+=4;
        }
    }

    void appendMethods(LinkedHashMap<String, pair> met, String parent ){
        int n = this.methodType.size()*4;
        for(String method : met.keySet()){
            if(this.methodType.get(method) == null){
                this.methodType.put(method, new pair(parent, n));
                n+=4;
            }else{
                this.methodType.get(method).var = parent;
            }
        }
    }


}
class pair{
    String var;
    int index;
    pair(){
        var = null;
        index = 0;
    }
    pair(pair p){
        var = p.var;
        index = p.index;
    }
    pair(String name, int ind){
        var = name;
        index = ind;
    }
    void print(){
        System.out.println(this.var + " " + this.index);
    }
}
