import java.io.IOException; 
import java.util.*; 
 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*; 
import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapred.*; 
import org.apache.hadoop.util.*; 
 
public class AvgTemperature { 
 
    
    public static void main(String[] args) throws Exception { 
        JobConf conf = new JobConf(AvgTemperature.class); 
        conf.setJobName("AvgTemp"); 
    
        conf.setOutputKeyClass(Text.class); 
        conf.setOutputValueClass(IntWritable.class); 
    
        conf.setMapperClass(AvgTemperatureMapper.class); 
        conf.setReducerClass(AvgTemperatureReducer.class); 
    
        conf.setInputFormat(TextInputFormat.class); 
        conf.setOutputFormat(TextOutputFormat.class); 
    
        FileInputFormat.setInputPaths(conf, new Path(args[0])); 
        FileOutputFormat.setOutputPath(conf, new Path(args[1])); 
    
        JobClient.runJob(conf); 
    } 
} 
 
 