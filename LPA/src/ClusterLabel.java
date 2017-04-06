import java.io.PrintStream;
import java.util.*;

class ClusterLabel
{

	private Map label;
	private Map labelweight;
	public Map attenuationMap;
	int j1;						//节点
	List list1;					//节点的邻接节点集合
	List<Map<Integer,Float>> list_new = new ArrayList<Map<Integer,Float>>();
	private float weight;
	private float overlap;
	private Random rand;

	public ClusterLabel(int i, float f)
	{
		initialize(i, f);
	}

	public ClusterLabel(int i, float f, int j, boolean flag)//i：顶点数, f：v的值
	{
		j1=j;
		initialize(i, f);
		if (flag)
		{
			label.put(Integer.valueOf(j), Float.valueOf(1.0F));//j是本身，1.0意味着对自身标签的从属度是100%
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
//			System.out.println("---------101输出lw:"+lw);
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
//			System.out.println("------------97输出map:"+map+"-------------");
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
			{
				int i = ((Integer)iterator.next()).intValue();
				if (label.containsKey(Integer.valueOf(i)))
					label.put(Integer.valueOf(i), Float.valueOf(((Float)label.get(Integer.valueOf(i))).floatValue() + ((Float)map.get(Integer.valueOf(i))).floatValue() * f));
				else
					label.put(Integer.valueOf(i), Float.valueOf(((Float)map.get(Integer.valueOf(i))).floatValue() * f));

				weight += f;
//				System.out.println("-----------107输出weight:"+weight+"--------------");
//				System.out.println("------------108输出clusterlabel:"+clusterlabel+"------------");
			}
		}
	}

	public void noMore(List listattenuation)
	{
		reduce(listattenuation); //去掉不符合要求的标签
		normalize(); //对从属系数进行归一化
	}
	/*
	 * @小庄
	 * 1.改进随机性，选择相同标签所在顶点度和最大的顶点，若有多个最大的，在随机选择
	 * 2.标签衰减值若为0不在传播
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

		HashMap hashmap1 = new HashMap();//邻接点的标签衰减值的集合
		HashMap hashmap2 = new HashMap();//记录标签重复次数
		HashMap hashmap3 = new HashMap();//记录改点传播后的标签衰减值
//		System.out.println("--------------163:"+listattenuation);
//		System.out.println("---------164输出labelweight:"+labelweight+"-----------");
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

		for (Iterator iterator = label.keySet().iterator(); iterator.hasNext();)//map的对象
		{
			int i = ((Integer)iterator.next()).intValue();
//			System.out.println("------------125 clusterlab中i："+i+"-------------");
//			System.out.println("------------126 clusterlab中weight:"+weight+"------------");
//			System.out.println("*****((Float)label.get(Integer.valueOf(i))).floatValue():"+((Float)label.get(Integer.valueOf(i))).floatValue()+"*********");
			val2 = (Double)hashmap1.get(i);
			if(hashmap2.containsKey(i))
				val2 = (Double)hashmap1.get(i)/(Integer)hashmap2.get(i);
			//			if(val2!=0){
			if (((Float)label.get(Integer.valueOf(i))).floatValue() / weight < f2)//与1/v进行比较  标签从属度小于1/V的情况
			{
				if (((Float)label.get(Integer.valueOf(i))).floatValue() > f)//f记录的标签从属度小于1/v的从属度最大的值
				{
					f = ((Float)label.get(Integer.valueOf(i))).floatValue();
//					if(((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2>fl){
//						fl=((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2;
//					}
				}
//				System.out.println("-------------134输出f："+f+"-------------");
				hashset.add(Integer.valueOf(i));//相等的v值
			} else if(val2 > 0)//标签从属度大于1/V的情况
			{
				f1 += ((Float)label.get(Integer.valueOf(i))).floatValue();
//				System.out.println("-------------139输出f1："+f1+"-------------");
			}else
				hashset.add(Integer.valueOf(i));
		}
		//		}
		if (f1 > 0.0F)//标签数小于v时，存在标签从属度大于1/V时
		{
			int j;
			for (Iterator iterator1 = hashset.iterator(); iterator1.hasNext(); label.remove(Integer.valueOf(j)))
				j = ((Integer)iterator1.next()).intValue();
			weight = f1;//标签数
		} 

		//标签数大于v时,既标签从属度全部小于v/1
		else//表签数大于v时,既标签从属度全部小于v/1
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
					arraylist.add(Integer.valueOf(k));//将合格的标签转移至arraylist
					System.out.println("----------------241输出arraylist:"+arraylist+"-----------");
				}
			} while (true);
			
			//判断从属度都小于1/v的情况下，1/v最大的标签中，标签所在顶点的度之和与衰减值乘积的值
			
				for(Iterator iterator = arraylist.iterator();iterator.hasNext();){
					int i = (Integer) iterator.next();
					val2 = (Double)hashmap1.get(i);
					if(hashmap2.containsKey(i))
						val2 = (Double)hashmap1.get(i)/(Integer)hashmap2.get(i);
					if(((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2>fl){
						fl=((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2;
					}
				}
				//移除乘积值小的标签
				for(Iterator iterator = arraylist.iterator();iterator.hasNext();){
					int i = ((Integer) iterator.next()).intValue();
					val2 = (Double)hashmap1.get(i);
					if(hashmap2.containsKey(i))
						val2 = (Double)hashmap1.get(i)/(Integer)hashmap2.get(i);
					if(((Integer) labelweight.get(Integer.valueOf(i))).intValue()*val2<fl)
						iterator.remove();
				}
				System.out.println("----------------fl:"+fl+"-----------");
				System.out.println("----------------266输出arraylist:"+arraylist+"-----------");
				if(!arraylist.isEmpty()){
				label.clear();
				int i1 = arraylist.size();
				int l = ((Integer)arraylist.get(rand.nextInt(i1))).intValue();//随机选取标签
//				System.out.println("-----------164输出i1:"+i1+"----------");
//				System.out.println("-----------164输出l:"+l+"----------");
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
//			System.out.println("---------178输出："+i+"---------");
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
//		System.out.println("-----------196输出s:"+s+"-------------");
		return s;
	}
}