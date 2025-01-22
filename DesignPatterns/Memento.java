package DesignPatterns;

import java.util.*;

public class Memento {

	public static void main(String[] args) {
		Editor editor = new Editor();
		History history = new History();
		
		editor.setContent("a");
		history.push(editor.createState());
		
		editor.setContent("b");
		history.push(editor.createState());
		
		editor.setContent("c");
		history.push(editor.createState());
		
		System.out.println(editor.getContent());		// last element editor holding
	
		editor.restore(history.pop());
		editor.restore(history.pop());
		editor.restore(history.pop());
		
		System.out.println(editor.getContent());
	}
}

class Editor {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public EditorState createState() {
		return new EditorState(content);
	}
	
	public void restore(EditorState state) {
		content = state.content();
	}
}

record EditorState(String content) {};

class History {
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
