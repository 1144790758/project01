package friends;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class friendsDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		args=new String[]{"G:/input/friends.txt","G:/output/friendoutput9"};
		
		Configuration conf=new Configuration();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(friendsDriver.class);
		job.setMapperClass(friendsMapper.class);
		job.setReducerClass(friendsreducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
		
	}
}
