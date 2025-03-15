package JavaSpecific.HashCodeProblems;
public class MyObj {
		int id;
		String s;
		
		public MyObj(int id, String s) {
			super();
			this.id = id;
			this.s = s;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getS() {
			return s;
		}
		public void setS(String s) {
			this.s = s;
		}
		
		@Override
		public int hashCode() {
			//final int prime = 31;
			int result = 1;
			//result = prime * result + ((s == null) ? 0 : s.hashCode());
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MyObj other = (MyObj) obj;
			if (s == null) {
				if (other.s != null)
					return false;
			} else if (!s.equals(other.s))
				return false;
			return true;
		}
	}