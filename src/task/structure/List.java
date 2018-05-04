package task.structure;


public interface List<T> {
	public String add(Object input);
	public String add(int index, Object input); 
	public Object get(int index); 
	public int getSize(); 
	public int indexOf(Object input); 
	public String remove(int index); 
	public String remove(Object data); 
	public String toString();

}