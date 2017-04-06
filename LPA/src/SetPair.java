import java.util.TreeSet;

class SetPair
	implements Comparable
{

	public int id;
	public TreeSet set;

	public SetPair(int i, TreeSet treeset)
	{
		id = i;
		set = treeset;
	}

	public int compareTo(SetPair setpair)
	{
		if (set.size() < setpair.set.size())
			return -1;
		if (set.size() > setpair.set.size())
			return 1;
		if (id < setpair.id)
			return -1;
		return id <= setpair.id ? 0 : 1;
	}

	public  int compareTo(Object obj)
	{
		return compareTo((SetPair)obj);
	}
}