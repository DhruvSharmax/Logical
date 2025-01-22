package challenges;

public class Train {
	Coach engine;
	class Coach{
		String name;
		Coach next;
		
		Coach(String name) {
			this.name=name;
		}
	}
	
	public static void main(String[] args) {
		Train train = new Train();
		train.add("engine1");
		for(int i=6;i>=1;i--)
		train.add("d"+i);
		train.add("b1");
		train.add("a1");
		train.add("engine2");
		
		print(train);
		
		Coach rev = train.reverse();
		
		Train rev_train = new Train();
		rev_train.engine = rev;
		
		print(rev_train);

	}

	private static void print(Train train) {
		Coach rev = train.engine;
		while(rev!=null) {
			System.out.println(rev.name);
			rev=rev.next;
		}
	}

	private Coach reverse() {
		Coach prev=null,curr=engine, next;
		while(curr!=null) {
			next = curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		return prev;
	}

	private void add(String name) {
		if(engine==null) {
			engine = new Coach(name);
			return;
		}
		Coach temp = engine;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=new Coach(name);
	}
}
