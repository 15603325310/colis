import java.io.*;
import java.lang.reflect.Array;
import java.util.*;



public class LPAOC
{

	static String separator = "------------------------------------------------------------------------";
	static String welcome1 = "***************************************";
	static String welcome2 = "* �ص�����LPA�㷨   *";
	static int delVerts = 0;
	static int delClusters = 0;
	static int simpleDelVerts = 0;
	static int simpleDelClusters = 0;
	private static ArrayList<Map<Integer, Float>> list_new;
	static List list_new1 = new ArrayList();

	public LPAOC()
	{
	}

	public static void main(String argsnon[])
	{
		System.out.println("**������ʼ**");
		String w=loginMenu();//���������ļ�����
		System.out.println("*******���W******");
		System.out.println(w);
		String args[]=w.split(" ");//����һ������   �ÿո���зָ�
//		System.out.println("************���args:"+Arrays.toString(args)+"***********");
		String s = "clusters-";
		String s1 = "clusters1-";
		String s2 = "clusters2-";
		Vector vector = null;//vector��ײ�����ṹ�ģ�����������ʹ�������������з��ʵ����/Vector();    ����һ����������ʹ���ڲ���������Ĵ�СΪ10�����׼��������Ϊ�㡣     Vector vec=new Vector();
		Object obj = null;
		boolean flag = true;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		int i = 0;
		float f = 1.0F;
		float f1 = 1.0F;
		int j = 0x7fffffff;//���� 32λ�������
		int k = 1;//��
		int l = 0;
		int i1 = 1;
		int j1 = 1;
		int i2 = Array.getLength(args); //�����  
		if (i2 < 1)
			printUsageAndExit();//�����С��1�������ʾ��Ϣ
		String s4 = args[0];//���������Ϣ����
//		System.out.println("********���S4*********");
//		System.out.println(s4);
		String s5 = (new File(s4)).getName();
		String s6 = (new StringBuilder()).append(s).append(s5).toString(); //��clusters-   s = "clusters-"
		String s7 = (new StringBuilder()).append(s).append(s5).toString();
		String s8 = null;
		String s9 = "";
		String s10 = "";
		String s11 = "";
		ArrayList arraylist = new ArrayList();//���㼯��
		ArrayList arraylist1 = new ArrayList();
		HashMap hashmap = new HashMap();
		ArrayList arraylist2 = arraylist;
		ArrayList arraylist3 = arraylist1;
		HashMap hashmap1 = hashmap;
		ArrayList arraylist4 = null;
		while (j1 < i2) //���뷽ʽ����ȷ����ת������
		{
			String s3 = args[j1++]; //��һ�����
			//						if ("-prop".equals(s3))
			//							j = Integer.parseInt(args[j1++]);
			//						else
			if ("-v".equals(s3))
			{
				f = Float.parseFloat(args[j1++]);//��������һ��Ϊָ��String��ʾ�µĸ����ʼ��ֵ����Float���valueOf����ִ�е�ֵ��
				f1 = f;
//				System.out.println("******���f1��"+f1+"*****");
			} else
				//							if ("-vs".equals(s3))
				//							{
				//								f = Float.parseFloat(args[j1++]);
				//								f1 = Float.parseFloat(args[j1++]);
				//							} else
				//							if ("-term".equals(s3))
				//								k = Integer.parseInt(args[j1++]);
				//							else
				if ("-repeat".equals(s3))
				{
					String args1[] = args[j1++].split("-");
//					System.out.println("*******�������args1[]:"+Arrays.toString(args1)+"*******");
					if (Array.getLength(args1) == 1)
					{
						l = 0;
						i1 = Integer.parseInt(args1[0]); //�ظ�����
//						System.out.println("**********���l��i1��"+l+","+i1+"********");
					} else
					{
						l = Integer.parseInt(args1[0]);
						i1 = Integer.parseInt(args1[1]);
//						System.out.println("**********���l��i1��"+l+i1+"********");
					}
				} else
					//								if ("-nosplit".equals(s3))
					//									flag = false;
					//								else
					//								if ("-extrasimplify".equals(s3))
					//									flag1 = true;
					//								else
					//								if ("-bi".equals(s3))
					//									flag2 = true;
					//								else
					//								if ("-w".equals(s3))
					//									flag3 = true;
					//								else
					if ("-mo".equals(s3))
						flag4 = true;
					else
						//									if ("-q".equals(s3))
						//										flag5 = true;
						//									else
						//									if ("-stats".equals(s3))
						//										i = Integer.parseInt(args[j1++]);
						//									else
						printUsageAndExit();
		}
		if (j < 1 || f < 1.0F)
			printUsageAndExit();
//		System.out.println("*****����printUsageAndExit()---122---*******");
//		System.out.println("********�˴���ת��647*******");
		int j2 = readBiGraphEdges(s4, arraylist, arraylist2, arraylist1, arraylist3, hashmap, hashmap1, arraylist4); //j2 ������arraylist1 3�ߵ����֣�hashmap��hashmap 1���������ı�ǩ��arraylist��arraylist2Ϊ����������Χ�Ķ��㼯�ϣ�arraylist4ΪȨ���������в�������������
//		System.out.println("***********���j2��"+j2+"*********");
		if (!flag5) //�в���q
//			System.out.println("*******�˴���ת��203********");
		showOptions(arraylist.size(), arraylist2.size(), j2, flag2, arraylist4, f, f1, j, i1, flag, flag1, flag4, s4, s10, s11); //��ʾ�ļ���Ϣ
		try
		{
			for (float f2 = f; f2 <= f1; f2++)//vֵ�ķ�Χ
			{
				double d = 0.0D;
				double d1 = 0.0D;
				double d2 = 0.0D;
				double d3 = 0.0D;
				double d4 = 0.0D;
				double d5 = 0.0D;
				double d6 = (-1.0D / 0.0D); //������
				double d7 = (-1.0D / 0.0D); //������
				String s13 = (new StringBuilder()).append("best-").append(s6).toString(); //best-clusters-�ļ���.txt
				Vector vector2 = null;
				for (int k1 = 0; k1 < l; k1++) //�ظ�������һ����Χ��ִ�����
//					System.out.println("*******���l: "+l+"*******");
				clusterGraph1(j, s4, arraylist, arraylist2, arraylist1, arraylist3, arraylist4, s6, s7, s8, f2, k, flag, flag1, null, i);
				for (int l1 = 0; l1 < i1; l1++) //i1Ϊrepeat����
				{
					VecPair vecpair = clusterGraph1(j, s4, arraylist, arraylist2, arraylist1, arraylist3, arraylist4, s6, s7, s8, f2, k, flag, flag1, null, i);
					Vector vector1 = vecpair.value;
					vector = vecpair.name; //[�ص���, Unused, ������, �ǵ�����������, ��������, ��ʱ��, ������, ����]
					if (flag4) //ģ������
						if (flag2) //˫������
						{
							d2 = ModOverlap.modOverlap(s10, s7);
							d5 = ModOverlap.modOverlap(s11, s8);
						} else
						{
							d2 = ModOverlap.modOverlap(s4, s6); //s4=karate.txt s6=clusters-karate.txt��d2ģ���
						}
					report(((Double)vector1.get(2)).doubleValue(), ((Double)vector1.get(3)).doubleValue(), ((Double)vector1.get(4)).doubleValue(), ((Double)vector1.get(5)).doubleValue(), d2, d5, ((Double)vector1.get(0)).doubleValue(), ((Double)vector1.get(1)).doubleValue(), flag2, flag4); //�����һ�μ�����
					d += d2; //��ģ��Ȳ�����Χ
					d1 += d2 * d2;
					d3 += d5;
					d4 += d5 * d5;
					vector2 = sumRes(vector2, vector1, 0); //��vector1��vector2��ӣ������Ժ���ƽ��ֵ
					if (d2 > d6 && i1 > 1)
					{
						d6 = d2;
						d7 = d5;
						copyFile(s6, s13);//clusters-karate.txt,best-clusters-karate.txt�������ģ����滻��best�ļ�
					}
				}

				if (i1 > 1)
				{
					System.out.println(separator);
					System.out.println((new StringBuilder()).append("vֵ=").append(f2).toString());
					if (flag4)
					{
						double d8 = d / (double)i1;//ƽ��ģ���
						double d10 = stdDev(d1, i1, d8); //ƽ��ģ��ȸ�����ΧstdDev
						String s14 = String.format("���ģ���= %.3f", new Object[] {
								Double.valueOf(d6)
						});
						String s15 = String.format(", ƽ��ģ��� = %.3f+-%.3f", new Object[] {
								Double.valueOf(d8), Double.valueOf(d10)
						});

						System.out.println((new StringBuilder()).append(s14).append(s15).toString()); //������ģ�����ƽ��ģ���
					}
					reportRes(vector2, vector, i1); //����������������
					System.out.println(separator);
				}
			}

		}
		catch (Exception exception)
		{
			System.err.println((new StringBuilder()).append("LPAOC error: ").append(exception.toString()).toString());
			exception.printStackTrace();
		}
	}

	private static void showOptions(int i, int j, int k, boolean flag, List list, float f, float f1, int l, 
			int i1, boolean flag1, boolean flag2, boolean flag3, String s, String s1, String s2)
	{
//		System.out.println("-----------218----------");
		System.out.println(welcome1);
		System.out.println(welcome2);
		System.out.println(welcome1);
		System.out.println((new StringBuilder()).append("�ļ��� = ").append(s).toString());
		System.out.print("������ ");
		if (list != null)
			System.out.print("��Ȩ��, ");
		else
			System.out.print("��Ȩ��, ");
		if (flag)
		{
			System.out.println("˫������");
			System.out.println((new StringBuilder()).append("  ").append(i).append("/").append(j).append(" ������, ").append(k).append(" ����").toString());
		} else
		{
			System.out.println("��������");
			System.out.println((new StringBuilder()).append("  ").append(i).append(" ������, ").append(k).append(" ����").toString());
		}

		System.out.print((new StringBuilder()).append("  v = ").append(f).toString());
		if (f < f1)
			System.out.println((new StringBuilder()).append(",...,").append(f1).toString());
		else
			System.out.println();
		if (l < 0x7fffffff)//���Ƶ�������
			System.out.println((new StringBuilder()).append("  �������������� ").append(l).toString());
		if (i1 > 1)
			System.out.println((new StringBuilder()).append("  �ظ� ").append(i1).append(" �β���ʾƽ��ֵ").toString());
		if (!flag1)
			System.out.println(" �����붥�㲻���ӵ�����");
		if (flag2)
			System.out.println("���������������");
		if (flag3)
		{
			System.out.print("  ������ļ�ģ��ȣ� ");

			System.out.println(s);
		}
		System.out.println(separator);
//		System.out.println("*****�ļ�������******-----258------");
	}

	public static VecPair clusterGraph(int i, String s, String s1, String s2, String s3, float f, int j, boolean flag, 
			boolean flag1, String s4, int k, boolean flag2, boolean flag3)
	{
		if (flag3)
			System.exit(1);
		VecPair vecpair = clusterGraph(i, s, s1, s2, s3, f, j, flag, flag1, s4, k, flag2);
		return vecpair;
	}

	public static VecPair clusterGraph(int i, String s, String s1, String s2, String s3, float f, int j, boolean flag, 
			boolean flag1, String s4, int k, boolean flag2)
	{
		boolean flag3 = s3 != null;
		ArrayList arraylist = new ArrayList();
		ArrayList arraylist1 = new ArrayList();
		HashMap hashmap = new HashMap();
		ArrayList arraylist2 = arraylist;
		ArrayList arraylist3 = arraylist1;
		HashMap hashmap1 = hashmap;
		ArrayList arraylist4 = null;
		if (flag3)
		{
			arraylist3 = new ArrayList();
			hashmap1 = new HashMap();
			arraylist2 = new ArrayList();
		}
		if (flag2)
			arraylist4 = new ArrayList();
		readBiGraphEdges(s, arraylist, arraylist2, arraylist1, arraylist3, hashmap, hashmap1, arraylist4);
		return clusterGraph1(i, s, arraylist, arraylist2, arraylist1, arraylist3, arraylist4, s1, s2, s3, f, j, flag, flag1, s4, k);
	}

	private static VecPair clusterGraph1(int i, String s, List list, List list1, List list2, List list3, List list4, String s1, 
			String s2, String s3, float f, int j, boolean flag, boolean flag1, String s4, 
			int k)
	{
//		System.out.println("----------297----------");
//		System.out.println("*********���list:"+list+"***********");
		Vector vector = new Vector();
		Vector vector1 = new Vector();
		long l5 = 0L;
		long l6 = 0L;
		boolean flag2 = s3 != null;
		Map map5 = null;
		Object obj = new HashMap();
		Object obj1 = new HashMap();
		List list5 = null;
		List list6 = null;
		boolean flag3 = k > 0 && !flag2;
		double d = 0.0D;
		double d1 = 0.0D;
		double d2 = 0.0D;
		double d3 = 0.0D;
		double d4 = 0.0D;
		Vector vector2 = new Vector();
		Vector vector3 = new Vector();
		boolean flag4 = true;
		boolean flag5 = false;
		Object obj2 = new HashMap();
		Object obj3 = new HashMap();
		long l1 = (new Date()).getTime();
		int j1;
		j1 = list.size();
		//			byte0 = 0;
		list5 = simpleClustering(j1, f);//���������ĵ�һ�����򵥵Ľ����������������Լ�������

		/*
		 * Ϊÿ����ǩ ��ʼ��˥��ֵ
		 */
		//			HashMap mapattenuation = (HashMap) clusteringattenaution(list);
		//			System.out.println("-------------------330"+mapattenuation+"-------------");

		List listattenuation = clusteringattenaution(list);
//		System.out.println("--------------335:clusteringattenuation:"+listattenuation+"-----------------");
		/*
		 * List<Map<String,Object>> list_new = new ArrayList<Map<String,Object>>();
					for(int k=0;k<list.size();k++){
					Map<String,Object> map = new HashMap<String,Object>();
					map.put("��ֵ","��ŵ�����ֵ");//�˴�ѭ���������������ֵ
					list_new.add(map);
					}
		 */
		//			List<Map<Integer,Float>> list_new = new ArrayList<Map<Integer,Float>>();
		//			list_new.add(mapattenuation);
		//			System.out.println(list_new.toString());

		int l;
		for (l = 0; l < i; l++)//iΪ����������    j = 0x7fffffff
		{
			list6 = propagateClusters(list5, list, list4, j1, f,listattenuation);//�õ���list6Ϊ����һ�κ������
//			System.out.println("-----------330���list6:"+list6+" --------");
			list5 = list6;
			listattenuation = list_new1;
			long l2 = (new Date()).getTime();
			if (j == 1)
			{
				Map map = clusteringSummary1(list5);//mapΪÿ�����������Ķ�����
				map5 = minSummary(((Map) (obj1)), map);//����һ�ε����õ������������Ķ��������бȽ�
				if (flag2)
				{
					Map map2 = clusteringSummary1(list6);
					obj = minSummary(((Map) (obj3)), map2);
				}
			} else
				if (j == 2)
				{
					Map map1 = clusteringSummary2(list5);
					map5 = minSummary(((Map) (obj1)), map1);
					if (flag2)
					{
						Map map3 = clusteringSummary2(list6);//����ÿ�����������Ķ��㣬list 5��6Ϊÿ�����������������Լ�������
						obj = minSummary(((Map) (obj3)), map3);//����һ�ε����õ����������������������Ƚ�
					}
				} else
					if (flag3)
					{
						if (!flag4)
						{
							Map map6 = clusteringSummary1(list5);////mapΪÿ�����������Ķ�����
							Map map7 = minSummary(((Map) (obj2)), map6);//����һ�ε����õ������������Ķ��������бȽ�
							if (map7.equals(obj2))//�����������������
							{
								System.out.println((new StringBuilder()).append("Termination 1 at ").append(l).toString());//l��������
								d = l;
								outputClusters(list5, list6, s1, s2, s3, list, list1, list2, list3, flag, flag1);
								d2 = ModOverlap.modOverlap(s, s2);
								System.out.println("------------385���d2:"+d2+"-------------");
								System.out.println((new StringBuilder()).append(l).append(": ").append(d2).toString());
								flag4 = true;
							}
							obj2 = map7;
						}
						if (!flag5)
						{
							Map map4 = clusteringSummary2(list5);
							obj = minSummary(((Map) (obj3)), map4);
							if (obj.equals(obj3))
							{
								System.out.println((new StringBuilder()).append("Termination 2 at ").append(l).toString());
								d1 = l;
								outputClusters(list5, list6, s1, s2, s3, list, list1, list2, list3, flag, flag1);
								d3 = ModOverlap.modOverlap(s, s2);
								System.out.println("------------401���d3:"+d3+"-------------");
								System.out.println((new StringBuilder()).append(l).append(": ").append(d3).toString());
								flag5 = true;
							}
							obj3 = obj;
						}
					}
			if (j >= 1 && map5.equals(obj1) && obj.equals(obj3))
			{
				long l3 = (new Date()).getTime();
				l2 = l3 - l2;
				l5 += l2;
				break;
			}
			long l4 = (new Date()).getTime();
			l2 = l4 - l2;//�����ʱ
			l5 += l2;
			obj1 = map5;//��һ�ε���������ܽ�
			obj3 = obj;
			if (flag3 && l == k)
			{
				outputClusters(list5, list6, s1, s2, s3, list, list1, list2, list3, flag, flag1);
				double d5 = ModOverlap.modOverlap(s, s2);
				System.out.println((new StringBuilder()).append(l).append(": ").append(d5).toString());
				vector2.add(Double.valueOf(d5));
				vector3.add(Integer.valueOf(l));
				k += Math.max(l / 10, 1);
			}
		}

		l1 = (new Date()).getTime() - l1;
		Vector vector4 = outputClusters(list5, list6, s1, s2, s3, list, list1, list2, list3, flag, flag1);
		if (flag2)
		{
			vector.add(Double.valueOf(((Double)vector4.get(2)).doubleValue() / (double)list.size()));
			vector1.add("Overlap mode 1");
			vector.add(Double.valueOf(((Double)vector4.get(3)).doubleValue() / (double)list1.size()));
			vector1.add("Overlap mode 2");
		} else
		{
			vector.add(Double.valueOf(((Double)vector4.get(2)).doubleValue() / (double)list.size()));
			vector1.add("�ص���");
			vector.add(Double.valueOf(0.0D));
			vector1.add("Unused");
		}
		vector.add(vector4.get(0));
		vector1.add("������");
		vector.add(vector4.get(1));
		vector1.add("�ǵ�����������");
		vector.add(Double.valueOf(l));
		vector1.add("��������");
		vector.add(Double.valueOf((double)l1 + ((Double)vector4.get(4)).doubleValue()));
		vector1.add("��ʱ��");
		vector.add(Double.valueOf(l5));
		//		vector1.add("Termination check time (included in total)");
		//		vector.add(vector4.get(4));
		//		vector1.add("Simplification time (included in total)");
		//		vector.add(Double.valueOf(list.size()));
		vector1.add("������");
		vector.add(Double.valueOf(nEdges(list)));
		vector1.add("����");
		if (flag3)
		{
			vector.add(Double.valueOf(d));
			vector1.add("Termination 1");
			vector.add(Double.valueOf(d1));
			vector1.add("Termination 2");
			vector.add(Double.valueOf(d2));
			vector1.add("Termination 1 modOverlap");
			vector.add(Double.valueOf(d3));
			vector1.add("Termination 2 modOverlap");
			for (int i1 = 0; i1 < vector2.size(); i1++)
			{
				vector.add(vector2.get(i1));
				vector1.add((new StringBuilder()).append(vector3.get(i1)).append("").toString());
			}

			vector2.clear();
		}
		return new VecPair(vector1, vector);
	}

	private static int nEdges(List list)
	{
		int j = 0;
		for (int i = 0; i < list.size(); i++)
			j += ((HashSet)list.get(i)).size();

		return j / 2;
	}

	private static double stdDev(double d, int i, double d1)
	{
		double d2 = d / (double)i - d1 * d1;
		double d3 = 0.0D;
		if (d2 < 0.0D)
			d3 = 0.0D;
		else
			d3 = Math.sqrt(d2);
		return d3;
	}

	private static Map minSummary(Map map, Map map1)
	{
//		System.out.println("-----473-----");
		if (map.keySet().equals(map1.keySet()))
		{
			Iterator iterator = map.keySet().iterator();
			HashMap hashmap = new HashMap();
			int i;
			for (; iterator.hasNext(); hashmap.put(Integer.valueOf(i), Float.valueOf(Math.min(((Float)map.get(Integer.valueOf(i))).floatValue(), ((Float)map1.get(Integer.valueOf(i))).floatValue()))))
				i = ((Integer)iterator.next()).intValue();

			return hashmap;
		} else
		{
			return map1;
		}
	}

	private static Map clusteringSummary1(List list)
	{
//		System.out.println("----------491-------");
		HashMap hashmap = new HashMap();
		for (int i = 0; i < list.size(); i++)
		{
			for (Iterator iterator = ((ClusterLabel)list.get(i)).labelSet().iterator(); iterator.hasNext();)
			{
				int j = ((Integer)iterator.next()).intValue();
				if (hashmap.containsKey(Integer.valueOf(j)))
					hashmap.put(Integer.valueOf(j), Float.valueOf(((Float)hashmap.get(Integer.valueOf(j))).floatValue() + 1.0F));
				else
					hashmap.put(Integer.valueOf(j), Float.valueOf(1.0F));
			}

		}

		return hashmap;
	}

	private static Map clusteringSummary2(List list)
	{
		System.out.println("-------------521-------------");
		HashMap hashmap = new HashMap();
		for (int i = 0; i < list.size(); i++)
		{
			Map map = ((ClusterLabel)list.get(i)).labelMap();
			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
			{
				int j = ((Integer)iterator.next()).intValue();
				float f = ((Float)map.get(Integer.valueOf(j))).floatValue();
				if (hashmap.containsKey(Integer.valueOf(j)))
					hashmap.put(Integer.valueOf(j), Float.valueOf(((Float)hashmap.get(Integer.valueOf(j))).floatValue() + f));
				else
					hashmap.put(Integer.valueOf(j), Float.valueOf(f));
			}

		}

		return hashmap;
	}

	/*
	 * @Сׯ
	 * Ϊ��ǩ��ʼ��˥��ֵ
	 */
	/*private static Map clusteringattenaution(List list)
	{
		HashMap hasmap = new HashMap();
		for (int i = 0; i<list.size(); i++)
		{
			hasmap.put(i, 1.0);
		}
		return hasmap;
	}
	 */
	private static List<Map<Integer, Float>> clusteringattenaution(List list){
		List<Map<Integer,Float>> list_new = new ArrayList<Map<Integer,Float>>();
		for (int i = 0; i<list.size(); i++)
		{
			HashMap hashmap = new HashMap();
			hashmap.put(i, 1.0);
			list_new.add(hashmap);
		}
		return list_new;
	}

	/*public static void propagate(String s, int i, String s1, String s2, String s3, float f)
	{
		ArrayList arraylist = new ArrayList();
		ArrayList arraylist1 = new ArrayList();
		ArrayList arraylist2 = new ArrayList();
		ArrayList arraylist3 = new ArrayList();
		HashMap hashmap = new HashMap();
		HashMap hashmap1 = new HashMap();
		readBiGraphEdges(s2, arraylist, arraylist1, arraylist2, arraylist3, hashmap, hashmap1, null);
		List list = readClusters(s1, i, f, hashmap);
		List list1 = propagateClusters(list, arraylist1, null, i, f);
		outputClusters(list1, list1, null, s3, s3, arraylist, arraylist, arraylist3, arraylist3, true, true);
	}
	 */

	private static List propagateClusters(List list, List list1, List list2, int i, float f,List listattenuation)//������Χ�������ѡ���ǩ
	{
//		System.out.println("-----------545---------");
		float f1 = 1.0F;

		Object obj = null;
//		System.out.println("********���list:"+list+"**********");
//		System.out.println("********���list1:"+list1+"**********");
		ArrayList arraylist = new ArrayList();
		List list_new2 = new ArrayList();
		for (int j = 0; j < list1.size(); j++)
		{
			ClusterLabel clusterlabel = new ClusterLabel(i, f, j, false);
			int k;

			for (Iterator iterator = ((HashSet)list1.get(j)).iterator(); iterator.hasNext(); clusterlabel.neighbour((ClusterLabel)list.get(k), f1, list1,k))//ѡ�񶥵�������ڽӱ�ǩ  iterator������,����ʱ������arraylist���ݸ���list
			{
				k = ((Integer)iterator.next()).intValue();
//				System.out.println("************���k:"+k+"**********");
				if (list2 != null)
					f1 = ((Float)((HashMap)list2.get(j)).get(Integer.valueOf(k))).floatValue();//list2�е�j���ֵΪk�Ĵ����ȵ�ֵ
//				System.out.println("---------572���f1:"+f1+"-------------");
			}

			clusterlabel.noMore(listattenuation);//���ѡ��һ����ǩ
			arraylist.add(clusterlabel);//�����ε���������ѡ���¼����
			list_new2.add(clusterlabel.attenuationMap);
		}
		list_new1 = list_new2;
//		System.out.println("*****************************579-------arraylist:"+arraylist+"---------");
//		System.out.println("*****************************579-------list_new:"+list_new1+"---------");
		return arraylist;
	}

	private static void reportRes(Vector vector, Vector vector1, int i)
	{
		if (vector != null)
		{
			for (int j = 0; j < vector.size(); j++)
				if (!"Unused".equals(vector1.get(j)))
					System.out.println(String.format("%s: %.3f", new Object[] {
							vector1.get(j), Double.valueOf(((Double)vector.get(j)).doubleValue() / (double)i)
					}));

		}
	}

	private static Vector sumRes(Vector vector, Vector vector1, int i)
	{
		Vector vector2 = new Vector();
		if (vector == null)
		{
			for (int j = i; j < vector1.size(); j++)
				vector2.add(vector1.get(j));

		} else
		{
			for (int k = i; k < vector1.size(); k++)
				vector2.add(Double.valueOf(((Double)vector.get(k - i)).doubleValue() + ((Double)vector1.get(k)).doubleValue()));

		}
		return vector2;
	}

	private static void report(double d, double d1, double d2, double d3, 
			double d4, double d5, double d6, double d7, boolean flag, boolean flag1)
	{
		String s = String.format("%.0f (%.0f) ������, %.0f �ε���, ��ʱ%.0fms", new Object[] {
				Double.valueOf(d), Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3)
		});
		if (flag)
		{
			s = (new StringBuilder()).append(s).append(String.format(", �ص���=%.3f/%.3f", new Object[] {
					Double.valueOf(d6), Double.valueOf(d7)
			})).toString();
			if (flag1)
				s = (new StringBuilder()).append(s).append(String.format(", ģ���=%.3f/%.3f", new Object[] {
						Double.valueOf(d4), Double.valueOf(d5)
				})).toString();
		} else
		{
			s = (new StringBuilder()).append(s).append(String.format(", �ص���=%.3f", new Object[] {
					Double.valueOf(d6)
			})).toString();
			if (flag1)
				s = (new StringBuilder()).append(s).append(String.format(", ģ���=%.3f", new Object[] {
						Double.valueOf(d4)
				})).toString();
		}
		System.out.println(s);
	}

	public static void readBiGraphEdges(String s, List list, List list1, List list2, List list3, List list4)
	{
		HashMap hashmap = new HashMap();
		HashMap hashmap1 = new HashMap();
		readBiGraphEdges(s, list, list1, list2, list3, ((Map) (hashmap)), ((Map) (hashmap1)), list4);
	}

	private static void copyFile(String s, String s1)
	{
		try
		{
			BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
			PrintStream printstream = new PrintStream(new FileOutputStream(s1));
			String s2;
			while ((s2 = bufferedreader.readLine()) != null) 
				printstream.println(s2);
			bufferedreader.close();
			printstream.close();
		}
		catch (Exception exception)
		{
			System.out.println((new StringBuilder()).append("�����ļ�����: ").append(s).append(" ").append(s1).toString());
			System.out.println(exception.toString());
			exception.printStackTrace();
			System.exit(1);
		}
	}

	private static int readBiGraphEdges(String s, List list, List list1, List list2, List list3, Map map, Map map1, List list4)
	{
//		System.out.println("---------------734------------------");
		int k = 0;
		int i1=-1;
		boolean flag = list2 != list3;
		try
		{
			BufferedReader bufferedreader = new BufferedReader(new FileReader(s)); //���ļ�
			do
			{
				String s1;
				if ((s1 = bufferedreader.readLine()) == null){
//					System.out.println("****************���s1��"+s1+"****************");
					break;
				}
				if (!"".equals(s1) && !s1.startsWith("#")) //s1��Ϊ���Ҳ���#�ſ�ʼ
				{	
//					System.out.println("--------------------���s1��"+s1+"****************");
				String as[] = s1.split("[ \t]"); //��x y�ֳɡ�x,y��,��ά����
//				System.out.println("**********�������as[]:"+Arrays.toString(as)+"********");
//				System.out.println("**********���list1:"+list1+"********");
//				System.out.println("**********���map:"+map+"********");
//				System.out.println("---------754--------");
				//					int i=Integer.parseInt(as[0]); 
				int i = nameInt(as[0], list2, map);//������ӱ�ǩ
//				System.out.println("*******���as[0]:"+as[0]+"********");
				//					int j=Integer.parseInt(as[1]);
				int j = nameInt(as[1], list3, map1);
//				System.out.println("*******���as[1]:"+as[1]+"********");
//				System.out.println("***********���i:"+i+"******���j:"+j+"*********");
				float f;
				if (Array.getLength(as) >= 3)
					f = Float.parseFloat(as[2]);//Ȩ��������Ȩ��    �ַ���ת����floatԭʼ���͵ĵ�������ֵ
				else
					f = 1.0F;
				if (flag || i != j)//flagΪfalse����ʾ���벻���ӵ������ṹ
				{
					do
					{
						if (list.size() >= i + 1)//size����i+1��ζ��i�Ѿ�¼�룬���������
							break;
						list.add(new HashSet());
						if (list4 != null)
							list4.add(new HashMap());
					} while (true);
					if (((HashSet)list.get(i)).add(Integer.valueOf(j)))
						k++;
					do
					{
						//							if(i==i1)//���as[0]��ֵ����һ�β��ȣ���List1
						if (list1.size() >= j + 1) //���list1��СС��j+1����list1�����ݼ�
							break;
						list1.add(new HashSet()); //��list1�����ݼ�
						if (list4 != null)
							list4.add(new HashMap());
						//							i1=i;
					} while (true);
					//						((HashSet)list1.get(i)).add(Integer.valueOf(j));
//					System.out.println("-------------790���list1��"+list1);
					((HashSet)list1.get(j)).add(Integer.valueOf(i));
					if (list4 != null)
					{
						((HashMap)list4.get(i)).put(Integer.valueOf(j), Float.valueOf(f));
						((HashMap)list4.get(j)).put(Integer.valueOf(i), Float.valueOf(f));
//						System.out.println("----------------796------------");
					}
				} else
				{
					System.out.println((new StringBuilder()).append("��Ч�ı���Ϣ").append(as[0]).append("/").append(as[1]).toString());
//					System.out.println("-------------801------------");
				}
				}

			} while (true);
//			System.out.println("--------806:"+list1.get(1));
			bufferedreader.close();
//			System.out.println("---------list1:");
//			System.out.println("-------815---------");
		}
		catch (Exception exception)
		{
			System.out.println((new StringBuilder()).append("readBiGraphEdges error:��ȡ�ļ����� ").append(s).toString());
			System.out.println(exception.toString());
			exception.printStackTrace();
			System.exit(1);
		}
//		System.out.println("**********���k:"+k+"**********");
		return k;
	}

	private static int nameInt(String s, List list, Map map)
	{
//		System.out.println("*******����nameInt����*******----830-----");
//		System.out.println("******���s,list,map:"+s+","+list+","+map);
		int i = 0;
		if (list == null)
			i = Integer.parseInt(s);
		else
			if (map.containsKey(s))//�ж�map���Ƿ���s
			{
				i = ((Integer)map.get(s)).intValue();
			} else
			{
				i = list.size();
				list.add(s); //��s����list
				map.put(s, Integer.valueOf(i));//��list�Ĵ�С��s����
			}
		return i;
	}








	private static Vector outputClusters(List list, List list1, String s, String s1, String s2, List list2, List list3, List list4, 
			List list5, boolean flag, boolean flag1)
	{
		long l = (new Date()).getTime();
		double d = 0.0D;
		int i = list.size();
		boolean flag2 = list4 != list5;
		ArrayList arraylist = new ArrayList();
		Object obj = null;
		Object obj1 = null;
		long l1 = (new Date()).getTime();
		List list6 = convertClusters(list, arraylist, 0);//�ı������ı����ʽ������ͬ�����Ķ���ŵ�һ�У�e.g.[[], [0, 1, 2, 3], [], [], [4, 6], [], [5, 7]]
		if (flag2)
		{
			List list8 = convertClusters(list1, arraylist, i);
			combineClusters(list6, list8);
			list2 = combineGraphs(list2, list3, i);
		}
		long l2 = (new Date()).getTime();
		HashSet hashset = flatten(list6);//flatten��
		long l3 = (new Date()).getTime();
		simpleSimplifyClusters(list6, arraylist);
		long l4 = (new Date()).getTime();
		list6 = removeEmpty(list6);//�����������͵���������
		int j = list6.size();
		long l5 = (new Date()).getTime();
		List list7;
		if (flag)
		{
			list7 = contiguous(list6, list2);//��ֿ�ӵ�в��ڽӶ��������
			if (j != list7.size())
				list7 = removeEmpty(list7);
		} else
		{
			list7 = list6;
		}
		if (flag1)
			simplifyClusters(list7);
		double d1 = list7.size();//�ǵ�����������
		long l6 = (new Date()).getTime();
		addSingletons(list7, hashset);//���뵥��������
		long l7 = (new Date()).getTime();
		double d2 = list7.size();//������
		System.out.println("------------898  list7:"+list7+"----------");
		l = (new Date()).getTime() - l;
		if (flag2)//˫������ѡ��
		{
			writeBiClusters(list7, s, list4, list5, i);
			List list9 = filterClusters(list7, i);
			writeClusters(list9, s2, list5);
			d = totSize(list9);
		}
		writeClusters(list7, s1, list4);
		double d3 = totSize(list7);//�ܴ�С
		Vector vector = new Vector();
		vector.add(Double.valueOf(d2));
		vector.add(Double.valueOf(d1));
		vector.add(Double.valueOf(d3));
		vector.add(Double.valueOf(d));
		vector.add(Double.valueOf(l));
		vector.add(Double.valueOf(l2 - l1));
		vector.add(Double.valueOf(l3 - l2));
		vector.add(Double.valueOf(l4 - l3));
		vector.add(Double.valueOf(l5 - l4));
		vector.add(Double.valueOf(l6 - l5));
		vector.add(Double.valueOf(l7 - l6));
		return vector;
	}

	private static int totSize(List list)
	{
		int i = 0;
		for (int j = 0; j < list.size(); j++)
			i += ((TreeSet)list.get(j)).size();

		return i;
	}

	private static List filterClusters(List list, int i)
	{
		ArrayList arraylist = new ArrayList();
		Iterator iterator = list.iterator();
		do
		{
			if (!iterator.hasNext())
				break;
			TreeSet treeset = (TreeSet)iterator.next();
			Iterator iterator1 = treeset.iterator();
			TreeSet treeset1 = new TreeSet();
			do
			{
				if (!iterator1.hasNext())
					break;
				int j = ((Integer)iterator1.next()).intValue();
				if (j >= i)
				{
					treeset1.add(Integer.valueOf(j - i));
					iterator1.remove();
				}
			} while (true);
			if (treeset.isEmpty())
				iterator.remove();
			if (!treeset1.isEmpty())
				arraylist.add(treeset1);
		} while (true);
		return arraylist;
	}

	private static List combineGraphs(List list, List list1, int i)
	{
		ArrayList arraylist = new ArrayList();
		int j;
		for (j = 0; j < list.size(); j++)
		{
			arraylist.add(new HashSet());
			for (Iterator iterator = ((HashSet)list.get(j)).iterator(); iterator.hasNext(); ((HashSet)arraylist.get(j)).add(Integer.valueOf(((Integer)iterator.next()).intValue() + i)));
		}

		for (; j < i; j++)
			arraylist.add(new HashSet());

		for (int k = 0; k < list1.size(); k++)
			arraylist.add(list1.get(k));

		return arraylist;
	}

	private static void combineClusters(List list, List list1)
	{
		for (int i = 0; i < list.size(); i++)
			((TreeSet)list.get(i)).addAll((Collection)list1.get(i));

	}

	private static void addSingletons(List list, HashSet hashset)
	{
		HashSet hashset1 = flatten(list);
		Iterator iterator = hashset.iterator();
		do
		{
			if (!iterator.hasNext())
				break;
			int i = ((Integer)iterator.next()).intValue();
			if (!hashset1.contains(Integer.valueOf(i)))
			{
				TreeSet treeset = new TreeSet();
				treeset.add(Integer.valueOf(i));
				list.add(treeset);
			}
		} while (true);
	}

	private static HashSet flatten(List list)
	{
		HashSet hashset = new HashSet();
		for (int i = 0; i < list.size(); i++)
			hashset.addAll((Collection)list.get(i));

		return hashset;
	}

	private static void writeClusters(List list, String s, List list1)
	{
		try
		{
			if ("".equals(s))
			{
				writeClusters(list, System.out, list1);
			} else
			{
				PrintStream printstream = new PrintStream(new FileOutputStream(s));
				writeClusters(list, printstream, list1);
				printstream.close();
			}
		}
		catch (Exception exception)
		{
			System.out.println((new StringBuilder()).append("writeClusters error ").append(exception.toString()).toString());
			exception.printStackTrace();
			System.exit(1);
		}
	}

	private static List convertClusters(List list, List list1, int i)
	{
		ArrayList arraylist = new ArrayList();
		for (int j = 0; j < list.size(); j++)
		{
			TreeSet treeset = ((ClusterLabel)list.get(j)).labelSet();
			int k;
			for (Iterator iterator = treeset.iterator(); iterator.hasNext(); ((TreeSet)list1.get(k)).remove(Integer.valueOf(k)))
			{
				for (k = ((Integer)iterator.next()).intValue(); arraylist.size() < k + 1; list1.add(null))
					arraylist.add(new TreeSet());

				((TreeSet)arraylist.get(k)).add(Integer.valueOf(j + i));
				if (list1.get(k) == null)
					list1.set(k, new TreeSet(treeset));
				else
					((TreeSet)list1.get(k)).retainAll(treeset);
			}

		}

		return arraylist;
	}

	private static List removeEmpty(List list)
	{
		ArrayList arraylist = new ArrayList();
		for (int i = 0; i < list.size(); i++)
		{
			TreeSet treeset = (TreeSet)list.get(i);
			if (treeset.size() > 1)
				arraylist.add(treeset);
		}

		return arraylist;
	}

	private static void simpleSimplifyClusters(List list, List list1)
	{
		for (int i = 0; i < list.size(); i++)
			if (list1.get(i) != null && !((TreeSet)list1.get(i)).isEmpty() && deletable(i, list1))
			{
				simpleDelClusters++;
				simpleDelVerts += ((TreeSet)list.get(i)).size();
				((TreeSet)list.get(i)).clear();
			}

	}

	private static boolean deletable(int i, List list)
	{
		TreeSet treeset = (TreeSet)list.get(i);
		for (Iterator iterator = treeset.iterator(); iterator.hasNext();)
		{
			int j = ((Integer)iterator.next()).intValue();
			if (!((TreeSet)list.get(j)).contains(Integer.valueOf(i)) || j < i)
				return true;
		}

		return false;
	}

	private static void simplifyClusters(List list)
	{
		int l = list.size();
		if (l <= 1)
			return;
		SetPair asetpair[] = new SetPair[l];
		for (int i = 0; i < l; i++)
			asetpair[i] = new SetPair(i, (TreeSet)list.get(i));

		list.clear();
		Arrays.sort(asetpair);
		int j;
		for (j = 0; j < l - 1; j++)
		{
			boolean flag = true;
			int k = j + 1;
			do
			{
				if (k >= l)
					break;
				if (asetpair[k].set.containsAll(asetpair[j].set))
				{
					delClusters++;
					delVerts += asetpair[j].set.size();
					flag = false;
					break;
				}
				k++;
			} while (true);
			if (flag)
				list.add(asetpair[j].set);
		}

		list.add(asetpair[j].set);
	}

	private static List contiguous(List list, List list1)
	{
		ArrayList arraylist = new ArrayList();
		for (int i = 0; i < list.size(); i++)
		{
			TreeSet treeset1;
			for (TreeSet treeset = (TreeSet)list.get(i); !treeset.isEmpty(); treeset.removeAll(treeset1))
			{
				treeset1 = contiguous(((Integer)treeset.iterator().next()).intValue(), treeset, list1);
				arraylist.add(treeset1);
			}

		}

		return arraylist;
	}

	private static TreeSet contiguous(int i, TreeSet treeset, List list)
	{
		LinkedList linkedlist = new LinkedList();
		TreeSet treeset1 = new TreeSet();
		linkedlist.add(Integer.valueOf(i));
		treeset1.add(Integer.valueOf(i));
		HashSet hashset;
		for (; !linkedlist.isEmpty(); treeset1.addAll(hashset))
		{
			i = ((Integer)linkedlist.removeFirst()).intValue();
			hashset = new HashSet((Collection)list.get(i));
			hashset.retainAll(treeset);
			hashset.removeAll(treeset1);
			linkedlist.addAll(hashset);
		}

		return treeset1;
	}

	private static void writeBiClusters(List list, String s, List list1, List list2, int i)
	{
		try
		{
			PrintStream printstream = new PrintStream(new FileOutputStream(s));
			for (int j = 0; j < list.size(); j++)
			{
				TreeSet treeset = (TreeSet)list.get(j);
				int k = treeset.size();
				if (k > 0)
				{
					TreeSet treeset1 = new TreeSet();
					TreeSet treeset2 = new TreeSet();
					for (Iterator iterator = treeset.iterator(); iterator.hasNext();)
					{
						int l = ((Integer)iterator.next()).intValue();
						if (l < i)
							treeset1.add(Integer.valueOf(l));
						else
							treeset2.add(Integer.valueOf(l - i));
					}

					writeCluster(treeset1, printstream, list1);
					printstream.print("\t");
					writeCluster(treeset2, printstream, list2);
					printstream.println();
				}
			}

		}
		catch (Exception exception)
		{
			System.out.println((new StringBuilder()).append("writeBiClusters error ").append(exception.toString()).toString());
			exception.printStackTrace();
			System.exit(1);
		}
	}

	private static void writeClusters(List list, PrintStream printstream, List list1)
	{
		for (int i = 0; i < list.size(); i++)
		{
			TreeSet treeset = (TreeSet)list.get(i);
			int j = treeset.size();
			if (j > 0)
			{
				writeCluster(treeset, printstream, list1);
				printstream.println();
			}
		}

	}

	private static void writeCluster(TreeSet treeset, PrintStream printstream, List list)
	{
		int l = treeset.size();
		Integer ainteger[] = new Integer[l];
		treeset.toArray(ainteger);
		String as[] = new String[l];
		for (int i = 0; i < l; i++)
		{
			int k = ainteger[i].intValue();
			if (list == null)
				as[i] = (new StringBuilder()).append(k).append("").toString();
			else
				as[i] = (String)list.get(k);
		}

		Arrays.sort(as);
		for (int j = 0; j < l; j++)
			printstream.print((new StringBuilder()).append(as[j]).append(" ").toString());

	}

	private static List simpleClustering(int i, float f)
	{
//		System.out.println("----------1248--------");
//		System.out.println("*******���i,f:"+i+","+f+"*********");
		ArrayList arraylist = new ArrayList();
		for (int j = 0; j < i; j++)
		{
			ClusterLabel clusterlabel = new ClusterLabel(i, f, j, true);
			arraylist.add(clusterlabel);
		}
//		System.out.println("**********arraylist:"+arraylist+"*************");
		return arraylist;
	}

	private static void printUsageAndExit()
	{
		System.out.println("**************1262��***********");
		System.err.println("LPAOCʹ�÷���");	
		System.err.println(" 1.�������ļ�����workspace");
		System.err.println(" 2.�����ļ���.vֵ�Լ��ظ�����");
		System.err.println(" 3.��workspace�в鿴�������");
		System.exit(1);
	}

	private static List readClusters(String s, int i, float f, Map map)
	{
		int i1 = 0;
		Object obj = null;
		ArrayList arraylist = new ArrayList();
		try
		{
			BufferedReader bufferedreader = new BufferedReader(new FileReader(s));
			String s1;
			while ((s1 = bufferedreader.readLine()) != null) 
			{
				String as[] = s1.split(" ");
				boolean flag;
				if (as[0].endsWith(":"))
					flag = true;
				else
					flag = false;
				for (int j = ((flag) ? 1 : 0); j < Array.getLength(as); j++)
				{
					int l;
					for (l = ((Integer)map.get(as[j])).intValue(); arraylist.size() < l + 1; arraylist.add(new ClusterLabel(i, f)));
					((ClusterLabel)arraylist.get(l)).add(i1);
				}

				i1++;
			}
			for (int k = 0; k < arraylist.size(); k++)
				((ClusterLabel)arraylist.get(k)).normalize();

		}
		catch (Exception exception)
		{
			System.err.println((new StringBuilder()).append("��������ʱ�������� ").append(exception.toString()).toString());
			exception.printStackTrace();
			System.exit(1);
		}
		return arraylist;
	}


	private static String loginMenu() {
		int type = 0;// vֵ
		int type1 = 0;//�ظ�����
		while (true) {

			Scanner input = null;
			input = new Scanner(System.in);
			System.out.println("*********�ص�����LPA�����㷨*********");

			System.out.println("*******************************");
			System.out.print("�����ļ���:");
			String filename = input.next();
			System.out.println("*************************");
			System.out.print("����vֵ:");
			type = input.nextInt();
			System.out.println("*************************");
			System.out.print("�����ظ�����:");
			type1 = input.nextInt();
			String postfix=" -v "+type+" -mo -repeat "+type1;
			String command =filename + postfix;
			System.out.println("-----------�����ļ���+Vֵ+�ظ�����---1333---");
			return(command);
		}

	}

}