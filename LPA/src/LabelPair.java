class LabelPair
{

	public float value;
	public int pos;

	public LabelPair(float f, int i)
	{
		value = f;
		pos = i;
	}

	public String toString()
	{
		return (new StringBuilder()).append(pos).append("/").append(value).toString();
	}
}