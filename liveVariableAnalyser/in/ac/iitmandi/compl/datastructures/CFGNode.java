/**
 * 
 */
package in.ac.iitmandi.compl.datastructures;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.util.TreeSet;

import syntaxtree.Node;

/**
 * @author arjun
 *
 */
public class CFGNode {

	
	private Node node;
	private NODETYPE type;
	private List<CFGNode> predecessorNodes;
	private List<CFGNode> successorNodes;
	public TreeSet<String> use;
	public TreeSet<String> def;
	public TreeSet<String> liveIn;
	public TreeSet<String> liveOut;
	public int line;

	


	public void addIn(String var){
		// if(use == null) use = new TreeSet<String>();
		liveIn.add(var);
	}
	
	public void addOut(String var){
		// if(use == null) use = new TreeSet<String>();
		liveOut.add(var);
	}
	
	public void addUse(String var){
		// if(use == null) use = new TreeSet<String>();
		use.add(var);
	}

	public void removeUse(String var){
		if(use == null) return;
		use.remove(var);
	}
	
	public void addDef(String var){
		if(this.type == NODETYPE.RETURNNODE) return;
		// if(def == null) def = new TreeSet<String>();
		if(var != null) def.add(var);
	}

	public void removeDef(String var){
		if(def == null) return;
		def.remove(var);
	}
	
	/**
	 * 
	 */
	public CFGNode(NODETYPE type) {
		this.type=type;
		this.def = new TreeSet<String>();
		this.use = new TreeSet<String>();
		this.liveIn = new TreeSet<String>();
		this.liveOut = new TreeSet<String>();
	}

	/**
	 * @param statement constructor
	 */
	public CFGNode(Node node) {
		this.node = node;
		this.type = NODETYPE.INTERMEDIATENODE;
		this.def = new TreeSet<String>();
		this.use = new TreeSet<String>();
		this.liveIn = new TreeSet<String>();
		this.liveOut = new TreeSet<String>();
	}
	
	/**
	 * @param node
	 * @param type
	 */
	public CFGNode(Node node, NODETYPE type) {
		this.node = node;
		this.type = type;
		this.def = new TreeSet<String>();
		this.use = new TreeSet<String>();
		this.liveIn = new TreeSet<String>();
		this.liveOut = new TreeSet<String>();
	}

	/**
	 * @return the node
	 */
	public Node getNode() {
		return node;
	}

	/**
	 * @param node the node to set
	 */
	public void setNode(Node node) {
		this.node = node;
	}

	/**
	 * @return the predecessorNodes
	 */
	public List<CFGNode> getPredecessorNodes() {
		return predecessorNodes;
	}
//	/**
//	 * @param predecessorNodes the predecessorNodes to set
//	 */
//	private void setPredecessorNodes(List<CFGNode> predecessorNodes) {
//		this.predecessorNodes = predecessorNodes;
//	}
	/**
	 * @return the successorNodes
	 */
	public List<CFGNode> getSuccessorNodes() {
		return successorNodes;
	}
//	/**
//	 * @param successorNodes the successorNodes to set
//	 */
//	private void setSuccessorNodes(List<CFGNode> successorNodes) {
//		this.successorNodes = successorNodes;
//	}
	
	
	
	public void addSuccessorNode(CFGNode cfgNode) {
		if(null!=cfgNode) {
			if(null==this.getSuccessorNodes()) {
				this.successorNodes = new ArrayList<>();
			}
			this.successorNodes.add(cfgNode);
		}
	}
	
	/**
	 * @return the type
	 */
	public NODETYPE getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(NODETYPE type) {
		this.type = type;
	}

	public void addPredecessorNode(CFGNode cfgNode) {
		if(null!=cfgNode) {
			if(null==this.getPredecessorNodes()) {
				this.predecessorNodes = new ArrayList<>();
			}
			this.predecessorNodes.add(cfgNode);
		}
	}
}
