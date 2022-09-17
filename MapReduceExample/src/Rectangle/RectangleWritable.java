package Rectangle;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class RectangleWritable implements WritableComparable<Object> {

	@Override
	public void readFields(DataInput din) throws IOException {
		length = din.readInt();
		width = din.readInt();
	}

	@Override
	public void write(DataOutput dout) throws IOException {
		dout.writeInt(length);
		dout.writeInt(width);
	}

	@Override
	public int compareTo(Object o) {
		RectangleWritable rw = (RectangleWritable) o;
		if (this.getLength() * this.getWidth() < rw.getLength() * rw.getWidth()) {
			return -1;
		} else if (this.getLength() * this.getWidth() > rw.getLength() * rw.getWidth()) {
			return 1;
		}
		return 0;
	}

	private int length, width;

	public RectangleWritable() {
		super();
	}

	public RectangleWritable(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
