package task.structure;

public interface Tree<T> {
	public T getRoot();
	public T getChild(T parent, int index); 
	public int getDegree(T parent);
	public boolean isLeaf(T node); 
}
