package Rectangle;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class RectanglePartitioner extends Partitioner<RectangleWritable, NullWritable>{

	@Override
	public int getPartition(RectangleWritable rw, NullWritable arg1, int arg2) {
		if(	rw.getLength()==rw.getWidth()) {
			return 0;
		}
		return 1;
	}

}
