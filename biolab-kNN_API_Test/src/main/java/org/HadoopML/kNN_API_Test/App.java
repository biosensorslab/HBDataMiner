package org.HadoopML.kNN_API_Test;

import org.BiolabML.mapreduce.algorithms.classification.knn.kNNDriver;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App  extends Configured 
{
    public static void main( String[] args )
    {
    	try
    	{
    		
	    	kNNDriver kNN =new kNNDriver();
	    	String input_path = "/user/demo/data/kNN/iris_input.csv";
	    	String model_path = "/user/demo/data/kNN/iris_model.csv";
	    	String out_path = "/user/demo/result/kNN";
	    	int k = 5;
	    	String indexList = "0,1,2,3";
	    	String nomialIndexList = "";
	    	String classIndex = "4";
	    	String distanceOption = "";
	    	String delimiter = ",";
	    	Configuration conf = kNN.kNN_Configuration("localhost", 
	    										input_path,
	    										model_path,
	    										out_path,
	    										k,
	    										indexList,
	    										nomialIndexList,
	    										classIndex,
	    										distanceOption,
	    										delimiter);
	    										
	    	int rtn = kNN.kNN_MRJob(conf);
	    	
	    	if(rtn == 0)
	    	{
	    		System.out.println("Success");
	    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.toString());
    	}
    }
}
