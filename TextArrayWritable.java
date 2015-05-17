//import java.util.ArrayList;

import java.util.ArrayList;

import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

@SuppressWarnings("rawtypes")
public class TextArrayWritable extends ArrayWritable implements WritableComparable
{
	//private Text first[];
    // These two methods are what people say is all you need for
    // creating an ArrayWritable subclass
    public TextArrayWritable() {
        super(Text.class);
    }
   
 public TextArrayWritable(ArrayList<Text> arr) {
     super(Text.class, gettextvalue(arr));
    }
    public static Text[] gettextvalue (ArrayList<Text> arr)
	{
  // super(Text.class);
    	//TextArrayWritable writable=new TextArrayWritable();
    	
		/*Text[] values=new Text[strings.length];
		for(int i=0;i<strings.length;i++)
		{
			values[i]=this.get(strings[i]);
		}
		writable.set(values);
		return writable;*/
    	Text[] values=new Text[arr.size()];
    	for(int i=0;i<arr.size();i++)
		{
    		 //values[i] = new Text(values[i].toString());
			values[i]=arr.get(i);
		}
    	// writable.set(values);
    	return (values);
	}
   /* public String[] returnarray(Text[] mytext)
	{
		//super(Text.class);
		String[] mystr=new String[mytext.length];
		//ArrayList<String> mylist=new ArrayList<String>();
		
		for(int i=0;i<mystr.length;i++)
		{
			mystr[i]=mystr[i].toString();
		}
		return mystr;
	}*/
	
   

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		TextArrayWritable twt=(TextArrayWritable)o;
		Writable[] source = this.get();
    	Writable[] target = twt.get();
    	int cmp = source.length - target.length;
    	if (cmp != 0) {
    	return cmp;
    	}
    	for (int i = 0; i < source.length; i++) {
    	cmp = ((Text) source[i]).compareTo((Text) target[i]);
    	if (cmp != 0) {
    	return cmp;
    	}
    	}
    	return cmp;
    	}
	}
