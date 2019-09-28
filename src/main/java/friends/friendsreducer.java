package friends;


import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class friendsreducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	

	
	ArrayList<String> list=new ArrayList<>();
	
//	Text k=new Text();
	IntWritable v=new IntWritable();
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context) throws IOException, InterruptedException {	
		
		int sum=0;
		for (IntWritable value : values) {
			if(value.get()==1){
				sum=value.get()+sum;
			}else {
				return;
			}
			
		}
		if(sum!=0){
			String line = key.toString();
			String[] str = line.split("-");
			if(str[0].equals(str[1])==false){				
				v.set(sum);
				
				if(list.contains(line)) {
					
				}else {
					
					//½«¼üÐ´Èëlist
					String str2=str[1]+"-"+str[0];
					list.add(str2);					
					context.write(key,v);
				}
				
				
			}
		}	
	}
}
