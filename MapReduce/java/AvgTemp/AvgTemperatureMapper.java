import java.io.IOException; 
import java.util.*; 

import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*; 
import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapred.*; 
import org.apache.hadoop.util.*; 
import org.apache.commons.lang.*; 
import org.apache.commons.lang.StringUtils;
  
 public class AvgTemperatureMapper extends MapReduceBase implements 
 	Mapper<LongWritable, Text, Text, IntWritable> { 
  
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) 
    	throws IOException { 
    	String[] line = value.toString().split(","); 
    	String datePart = line[1]; 
   
    	String temp = line[10]; 
   
    	if(StringUtils.isNumeric(temp)) 
    		output.collect(new Text(datePart), new IntWritable(Integer.parseInt(temp))); 
    } 
} 


 