package Question;

public class Answer {
	String id;
	String que_id;
	String context;
	int num;//ÈËÊý

	Answer() {
		super();
	}

	public Answer(String id, String que_id, String context) {
		super();
		this.id = id;
		this.que_id = que_id;
		this.context = context;
	}
	
	public Answer(String id, String que_id, String context, int num) {
		super();
		this.id = id;
		this.que_id = que_id;
		this.context = context;
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQue_id() {
		return que_id;
	}

	public void setQue_id(String que_id) {
		this.que_id = que_id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
