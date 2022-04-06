 
import java.io.IOException; 
import java.util.*; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*; 
import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapred.*; 
import org.apache.hadoop.util.*; 
  
public class AvgTemperatureReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> { 
  
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) 
		throws IOException { 
			
		int sumTemps = 0; 
		int numItems = 0;
          
		while(values.hasNext() ) 
		{        
			sumTemps += values.next().get(); 
			numItems += 1; 
		}     
		output.collect(key, new IntWritable(sumTemps / numItems)); 
    } 
       
} 
