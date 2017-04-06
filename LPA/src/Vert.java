class Vert
	implements Comparable
{

	public int id;
	public int degree;

	public Vert(int i, int j)
	{
		id = i;
		degree = j;
	}

	public int compareTo(Vert vert)
	{
		if (degree < vert.degree)
			return -1;
		if (degree > vert.degree)
			return 1;
		if (id < vert.id)
			return -1;
		return id <= vert.id ? 0 : 1;
	}

	public  int compareTo(Object obj)
	{
		return compareTo((Vert)obj);
	}
}