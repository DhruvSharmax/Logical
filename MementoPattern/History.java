package MementoPattern;

import java.util.ArrayList;
import java.util.List;

public class History {
	List<EditorState> states = new ArrayList<>();
	
	public void push(EditorState state) {
		states.add(state);
	}
	
	public EditorState pop() {
		int lastIndex = states.size()-1;
		EditorState state = states.get(lastIndex);
		states.remove(lastIndex);
		return state;
	}
}
