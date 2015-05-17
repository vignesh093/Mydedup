
import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;



public class Mydedupdriver {
	public static void main(String args[]) throws Exception
	{
		if(args.length!=2)
			{
			System.err.println("Usage: Worddrivernewapi <input path> <output path>");
			System.exit(-1);
			}
		Job job=new Job();
		job.setJarByClass(Mydedupdriver.class);
		job.setJobName("Mydedupdriver");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		//job.setInputFormatClass(SequenceFileInputFormat.class);
		//job.setOutputFormatClass(SequenceFileOutputFormat.class);
		 job.setOutputFormatClass(TextOutputFormat.class);
	        job.setInputFormatClass(TextInputFormat.class);
		job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
		
		job.setMapperClass(Mydedupmapper.class);
	//	job.setReducerClass(Mydedupreducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		
		job.setNumReduceTasks(0);
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
		
	}

}
