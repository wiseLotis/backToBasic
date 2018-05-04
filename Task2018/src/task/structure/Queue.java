package task.structure;


public interface Queue<T> {
	/**
	 * 큐의 마지막에 객체 추가 
	 * @param obj 추가할 객체 
	 */
	String add(T obj); 
	/**
	 * 큐가 비었는지 확인 
	 * @return true : 큐에 데이터 없음 
	 */
	boolean isEmpty(); 
	/**
	 * 
	 */
	T peek();
	/**
	 *  
	 */
	T pop(); 
	
	/**
	 * 큐에 들어있는 데이터 크기 
	 * @return 데이터 갯수 
	 */
	int getSize(); 	
	/**
	 * 큐 내용 모두 비우기 
	 */
	void clear(); 
}