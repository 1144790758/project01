package friends;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class friendsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	Text k = new Text();
	IntWritable v = new IntWritable();

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		// tom hello hadoop cat
		String line = value.toString();

		String[] sp = line.split(" ");

		for (int i = 0; i < sp.length - 1; i++) {
			for (int j = i+1; j < sp.length; j++) {
				if (i > 0) {
					v.set(1);
					k.set(sp[j] + "-" + sp[i]);

					context.write(k, v);

					k.set(sp[i] + "-" + sp[j]);
					v.set(1);
					context.write(k, v);
				} else if(i==0){
					v.set(0);
					k.set(sp[j] + "-" + sp[i]);

					context.write(k, v);
					v.set(0);
					k.set(sp[i] + "-" + sp[j]);

					context.write(k, v);
				}
			}
		}
	}

}
