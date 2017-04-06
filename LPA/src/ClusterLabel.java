import java.io.PrintStream;
import java.util.*;

class ClusterLabel
{

	private Map label;
	private Map labelweight;
	public Map attenuationMap;
	int j1;						//�ڵ�
	List list1;					//�ڵ���ڽӽڵ㼯��
	List<Map<Integer,Float>> list_new = new ArrayList<Map<Integer,Float>>();
	private float weight;
	private float overlap;
	private Random rand;

	public ClusterLabel(int i, float f)
	{
		initialize(i, f);
	}

	public ClusterLabel(int i, float f, int j, boolean flag)//i��������, f��v��ֵ
	{
		j1=j;
		initialize(i, f);
		if (flag)
		{
			label.put(Integer.valueOf(j), Float.valueOf(1.0F));//j�Ǳ���1.0��ζ�Ŷ������ǩ�Ĵ�������100%
			weight = 1.0F;
		}
	}

	private void initialize(int i, float f)
	{
		labelweight=new TreeMap();
		label = new TreeMap();
		weight = 0.0F;
		if (f == 0.0F)
			overlap = i;
		else
			overlap = f;
		rand = new Random();
	}

	public Map getLabel()
	{
		return label;
	}

	public float getWeight()
	{
		return weight;
	}

	public TreeSet labelSet()
	{
		return new TreeSet(label.keySet());
	}

	public Map labelMap()
	{
		return label;
	}

	public void add(int i)
	{
		if (label.containsKey(Integer.valueOf(i)))
		{
			System.out.println((new StringBuilder()).append("Trying to add ").append(i).append(" more than once").toString());
		} else
		{
			label.put(Integer.valueOf(i), Float.valueOf(1.0F));
			weight++;
		}
	}

	public boolean sameAs(ClusterLabel clusterlabel)
	{
		Map map = clusterlabel.getLabel();
		for (Iterator iterator = label.keySet().iterator(); iterator.hasNext();)
		{
			int i = ((Integer)iterator.next()).intValue();
			if (!map.containsKey(Integer.valueOf(i)))
				return false;
			if ((double)((Float)label.get(Integer.valueOf(i))).floatValue() < (double)((Float)map.get(Integer.valueOf(i))).floatValue() - 0.001D || (double)((Float)label.get(Integer.valueOf(i))).floatValue() > (double)((Float)map.get(Integer.valueOf(i))).floatValue() + 0.001D)
				return false;
		}

		for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext();)
		{
			int j = ((Integer)iterator1.next()).intValue();
			if (!label.containsKey(Integer.valueOf(j)))
				return false;
		}

		return true;
	}

	public void neighbour(ClusterLabel clusterlabel, float f,List list1,int k)
	{
		this.list1=list1;
		int lw=0;
		if (clusterlabel.getWeight() > 0.0F)
		{
			//			Iterator iterator1=((HashSet) list1.get(k)).iterator();
			//			while(iterator1.hasNext()){
			//				iterator1.next();
			//				lw=lw+1;
			lw = ((HashSet)list1.get(k)).size();
//			System.out.println("---------101���lw:"+lw);
			//			}
			Map map1=clusterlabel.getLabel();
			for(Iterator iterator=map1.keySet().iterator(); iterator.hasNext();)
			{
				int i=((Integer)iterator.next()).intValue();
				if(labelweight!=null){
					if(labelweight.containsKey(Integer.valueOf(i)))
						labelweight.put(Integer.valueOf(i), lw+(((Integer) labelweight.get(Integer.valueOf(i))).intValue()));
					else
						labelweight.put(Integer.valueOf(i), lw); 
				}
			}
			Map map = clusterlabel.getLabel();
//			System.out.println("------------97���map:"+map+"-------------");
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
			{
				int i = ((Integer)iterator.next()).intValue();
				if (label.containsKey(Integer.valueOf(i)))
					label.put(Integer.valueOf(i), Float.valueOf(((Float)label.get(Integer.valueOf(i))).floatValue() + ((Float)map.get(Integer.valueOf(i))).floatValue() * f));
				else
					label.put(Integer.valueOf(i), Float.valueOf(((Float)map.get(Integer.valueOf(i))).floatValue() * f));

				weight += f;
//				System.out.println("-----------107���weight:"+weight+"--------------");
//				System.out.println("------------108���clusterlabel:"+clusterlabel+"------------");
			}
		}
	}

	public void noMore(List listattenuation)
	{
		reduce(listattenuation); //ȥ��������Ҫ��ı�ǩ
		normalize(); //�Դ���ϵ�����й�һ��
	}
	/*
	 * @Сׯ
	 * 1.�Ľ�����ԣ�ѡ����ͬ��ǩ���ڶ���Ⱥ����Ķ��㣬���ж�����ģ������ѡ��
	 * 2.��ǩ˥��ֵ��Ϊ0���ڴ���
	 */
	private void reduce(List listattenuation)
	{
		HashSet hashset = new HashSet();
		float f = 0.0F;
		float f1 = 0.0F;
		float f2 = 1.0F / overlap;
		double fl=0;
		int val1=2;
		double val2;

		HashMap hashmap1 = new HashMap();//�ڽӵ�ı�ǩ˥��ֵ�ļ���
		HashMap hashmap2 = new HashMap();//��¼��ǩ�ظ�����
		HashMap hashmap3 = new HashMap();//��¼�ĵ㴫����ı�ǩ˥��ֵ
//		System.out.println("--------------163:"+listattenuation);
//		System.out.println("---------164���labelweight:"+labelweight+"-----------");
		for(Iterator iterator = ((HashSet)list1.get(j1)).iterator(); iterator.hasNext();)
		{
			int i = ((Integer)iterator.next()).intValue();
			for(Iterator iterator1 = ((HashMap)listattenuation.get(i)).entrySet().iterator(); iterator1.hasNext();)
			{
				Map.Entry entry = (Map.Entry) iterator1.next();
				int key = (Integer)entry.getKey();
				Double val = (Double)entry.getValue();
				//				System.out.println("------------------166: key:  val:"+key+" "+val);
				if(hashmap1.containsKey(key))
				{
					val =((Double)hashmap1.get(key) + val);
					hashmap1.put(key, val);
					if(hashmap2.containsKey(key))
					{
						val1 = (Integer)hashmap2.get(key)+1;
						hashmap2.put(key, val1);
					}else
						hashmap2.put(key, val1);
				}else
					hashmap1.put(key, val);
			}
		}
//		System.out.println("------------------183:"+hashmap1);
//		System.out.println("------------------184:"+hashmap2);

		for (Iterator iterator = label.keySet().iterator(); iterator.hasNext();)//map�Ķ���
		{
			int i = ((Integer)iterator.next()).intValue();
//			System.out.println("------------125 clusterlab��i��"+i+"-------------");
//			System.out.println("------------126 clusterlab��weight:"+weight+"------------");
//			System.out.println("*****((Float)label.get(Integer.valueOf(i))).floatValue():"+((Float)label.get(Integer.valueOf(i))).floatValue()+"*********");
			val2 = (Double)hashmap1.get(i);
			if(hashmap2.containsKey(i))
				val2 = (Double)hashmap1.get(i)/(Integer)hashmap2.get(i);
			//			if(val2!=0){
			if (((Float)label.get(Integer.valueOf(i))).floatValue() / weight < f2)//��1/v���бȽ�  ��ǩ������С��1/V�����
			{
				if (((Float)label.get(Integer.valueOf(i))).floatValue() > f)//f��¼�ı�ǩ������С��1/v�Ĵ���������ֵ
				{
					f = ((Float)label.get(Integer.valueOf(i))).floatValue();
//					if(((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2>fl){
//						fl=((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2;
//					}
				}
//				System.out.println("-------------134���f��"+f+"-------------");
				hashset.add(Integer.valueOf(i));//��ȵ�vֵ
			} else if(val2 > 0)//��ǩ�����ȴ���1/V�����
			{
				f1 += ((Float)label.get(Integer.valueOf(i))).floatValue();
//				System.out.println("-------------139���f1��"+f1+"-------------");
			}else
				hashset.add(Integer.valueOf(i));
		}
		//		}
		if (f1 > 0.0F)//��ǩ��С��vʱ�����ڱ�ǩ�����ȴ���1/Vʱ
		{
			int j;
			for (Iterator iterator1 = hashset.iterator(); iterator1.hasNext(); label.remove(Integer.valueOf(j)))
				j = ((Integer)iterator1.next()).intValue();
			weight = f1;//��ǩ��
		} 

		//��ǩ������vʱ,�ȱ�ǩ������ȫ��С��v/1
		else//��ǩ������vʱ,�ȱ�ǩ������ȫ��С��v/1
		{
			ArrayList arraylist = new ArrayList();
			Iterator iterator2 = hashset.iterator();
			do
			{
				if (!iterator2.hasNext())
					break;
				int k = ((Integer)iterator2.next()).intValue();
				val2 = (Double)hashmap1.get(k);
				if (((Float)label.get(Integer.valueOf(k))).floatValue() == f){
					arraylist.add(Integer.valueOf(k));//���ϸ�ı�ǩת����arraylist
					System.out.println("----------------241���arraylist:"+arraylist+"-----------");
				}
			} while (true);
			
			//�жϴ����ȶ�С��1/v������£�1/v���ı�ǩ�У���ǩ���ڶ���Ķ�֮����˥��ֵ�˻���ֵ
			
				for(Iterator iterator = arraylist.iterator();iterator.hasNext();){
					int i = (Integer) iterator.next();
					val2 = (Double)hashmap1.get(i);
					if(hashmap2.containsKey(i))
						val2 = (Double)hashmap1.get(i)/(Integer)hashmap2.get(i);
					if(((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2>fl){
						fl=((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2;
					}
				}
				//�Ƴ��˻�ֵС�ı�ǩ
				for(Iterator iterator = arraylist.iterator();iterator.hasNext();){
					int i = ((Integer) iterator.next()).intValue();
					val2 = (Double)hashmap1.get(i);
					if(hashmap2.containsKey(i))
						val2 = (Double)hashmap1.get(i)/(Integer)hashmap2.get(i);
					if(((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2<fl)
						iterator.remove();
				}
				System.out.println("----------------fl:"+fl+"-----------");
				System.out.println("----------------266���arraylist:"+arraylist+"-----------");
				if(!arraylist.isEmpty()){
				label.clear();
				int i1 = arraylist.size();
				int l = ((Integer)arraylist.get(rand.nextInt(i1))).intValue();//���ѡȡ��ǩ
//				System.out.println("-----------164���i1:"+i1+"----------");
//				System.out.println("-----------164���l:"+l+"----------");
				label.put(Integer.valueOf(l), Float.valueOf(1.0F));
				weight = 1.0F;
			}
		}
		for(Iterator iterator = label.keySet().iterator(); iterator.hasNext();)
		{
			int i = (Integer)iterator.next();
//			System.out.println("-------------255:"+i);
			val2 = (Double)hashmap1.get(i);
			if(hashmap2.containsKey(i))
			{
				val2 = (Double)hashmap1.get(i)/(Integer)hashmap2.get(i);
			}
			hashmap3.put(i, val2-0);
		}
//		System.out.println("--------------260:"+label);
//		System.out.println("--------------261:"+hashmap3);
		attenuationMap = hashmap3;
	}
	public void normalize()
	{
		if (weight > 0.0F)
		{
			int i = 0;
			for (Iterator iterator = label.keySet().iterator(); iterator.hasNext(); label.put(Integer.valueOf(i), Float.valueOf(((Float)label.get(Integer.valueOf(i))).floatValue() / weight)))
				i = ((Integer)iterator.next()).intValue();
//			System.out.println("---------178�����"+i+"---------");
			weight = 1.0F;
		}
	}

	public String toString()
	{
		String s = "";
		for (Iterator iterator = label.keySet().iterator(); iterator.hasNext();)
		{
			int i = ((Integer)iterator.next()).intValue();
			float f = ((Float)label.get(Integer.valueOf(i))).floatValue();
			if (!"".equals(s))
				s = (new StringBuilder()).append(s).append("/").toString();
			s = (new StringBuilder()).append(s).append(String.format("%d:%.3f", new Object[] {
					Integer.valueOf(i), Float.valueOf(f)
			})).toString();
		}
//		System.out.println("-----------196���s:"+s+"-------------");
		return s;
	}
}