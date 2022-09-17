package shiyan;
import java.io. BufferedReader ;
import java.io. BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream ;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner ;
public class FileOperator {
	public static final String LINE_END_TAG="\r\n";
	public static final String END_INPUT="--END";
	
	//创建文件并写入数据
	public void createFile(Scanner scanner) {
	System.out.println("请输入文件名称: ");
	String fileName = scanner.nextLine(); //获取文件名称
	File file = new File(fileName);
	//如果文件不存在，则创建文件
	if(!file.exists()) {
		try{
		   file.createNewFile();
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
	}
		System.out.println("请输入想要写入文件的内容，以-- END结束输入: ");
		//获取想要写入文件的内容
		String line = scanner .nextLine();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){ 
		    while(true) {
			   //如果不是结束输入的标识，则直接结束输入
			    if(END_INPUT.equals(line)) {
				return;
				}
			bw.write(line.concat(LINE_END_TAG));
			line = scanner.nextLine();
		    }
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("文件创建成功!请执行后续指令! ");
	}
	
	//删除文件

	public void delFile(Scanner scanner) {
	    System.out.println("请输入想要删除的文件全路径: ");
	    String filePath = scanner .nextLine();
	    File file = new File(filePath);
	    if(file.exists() && file.isFile()) {
	       //文件存在且不是目录，则删除文件
		   file.delete();
	 	   System.out.println("文件删除成功!删除文件:"+file.getAbsolutePath());
	    }
		 else {
			System.out.println("文件不存在，无法删除!请执行后续指令! ");
		 }
	}
	
	//复制文件
	public void copyFile(Scanner scanner) {
		System.out.println("请输入想要复制的文件全路径：");
		String filePath = scanner.nextLine();
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("文件不存在!");
			return;
		}
		if(!file.isFile()) {
			System.out.println("不是文件，无法复制!");
			return;
		}
	
	    //获取文件路径
	    String path = filePath.substring(0, filePath.lastIndexOf("\\")+ 1);
	    System.out.println("请输入想要复制到的文件名称: ");
	    String name = scanner.nextLine();
	    File newFile = new File(path.concat(name));
	    if(newFile.exists()) {
	    	System.out.println("目标文件已存在，是否覆盖(Y/N):");
	    	String tag = scanner.nextLine();
	    	if ("N".equals(tag)){
	    			System.out.println("请输入想要复制到的文件名称: ");
	    			name = scanner.nextLine();
	    			newFile = new File(path.concat(name));
	    	}
	    }
		//读取源文件内容并写入目标文件中
		try(FileInputStream fis = new FileInputStream(file);
				FileOutputStream fos = new FileOutputStream(newFile)){
			byte[] buf = new byte[1024];
			//读取数据
			while(fis.read(buf)!= -1) {
			//如果有内容，则进行文件写入
			    fos.write(buf);
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("文件复制成功!");
	}
	
	//读取执行文件，进行非实时文件处理 
	public void execFile(Scanner scanner){
			System.out.println("请输入想要执行的执行文件: ");
			String filePath = scanner.nextLine();
			File file = new File(filePath);
			if (file.exists()) {
			    System.out.println("执行文件不存在! ");
			    return;
			if (file.isFile()) {
			    System.out.println("不是文件，无法进行执行! ");
			    return;
			    System.out.println("开始执行执行文件: ");
	   			// 执行执行文件的逻辑
	   			try (BufferedReader br=new BufferedReader(new FileReader(file))){
	   				String line = br.readLine();
	   				while(null!=line&&!"".equals(line)) {
	   					String infos[] = line.split("");
	   					switch(infos[0]) {
	   					case"1":
	   						createFileByBatch(infos);
	   						break;
	   					case "2" :
                            delFileByBatch(infos);
                            break;
                        case "3":
                            copyFileByBatch(infos);
                            break;
                        default:
                            System.out.println("指令错误! ");
                            break;
	   					}
	   					line = br.readLine();//读取下一行
	   				}
	   			}catch(FileNotFoundException e) {
	   				e.printStackTrace();
	   			}catch(IOException e) {
	   				e.printStackTrace();
	   			}
	   			System.out.println("结束执行执行文件!");
			}
			//执行文件的文件创建方法
			public void createFileByBatch(String[] infos) {
				File file = new File(infos[1]);
				//文件不存在就创建，否则覆盖
				if(!file.exists()) {
					try {
					   file.createNewFile();
					}catch(IOException e) {
						e.printStackTrace();
					}
				}
    			//没有默认写入的数据
				if(null == infos[2] || "".equals(infos[2]){
					return;
				}
				//将数据写入创建的文件中
				try(FileOutputStream fos = new FileOutputStream(file)){
					for(int i= 2;i<infos.length;i++) {
						//如果是文件结束
	                    if (END_INPUT.equals(infos[i]))
						System.out.println("文件创建内容插入结束!创建成功! ");
	                    return;
					}
					if (!LINE_END__TAG.equals(infos[2])) {
						fos.write(infos[2].getBytes());
						fos.write("".getBytes());
					}else {
						fos.write(LINE_END_TAG.getBytes());
					}
			    }catch(FileNotFoundException e) {
				        e.printStackTrace();
			    }catch(IOException e) {
			           	e.printStackTrace();
			    }
			    System.out.println("创建文件: \" + infos[1]+\"成功! ");
			}
			//执行文件的文件删除方法
			public void delFileByBatch(String[] infos) {
				File file = new File(infos[1]);
				//文件不存在就创建，否则覆盖
				if(file.exists()|| !file.isFile()) {
				System.out.println("文件不存在或者不是文件，无需删除! ");
				} else {
				//文件存在，则删除文件
				file.delete();
				System.out.println("文件删除成功! ");
				}
			}
			//执行文件的文件赋值方法
			public void copyFieByBatch(String[] infos) {
				File file = new File(infos[1]);
				File newFile = new File(infos[2]);
				if(file.exists()||!file.isFile()) {
					System.out.println("文件不在存在成者不是文件，无法复制!");
				    return;
				}
				//复制副本文件不存在则创建
				if (newFile.exists()) {
					try {
					   newFile.createNewFile();
					} catch (IOException e) {
					      e.printStackTrace();
					}
				}
				//读取目标数据，写入副本文件
				try(FileOutputStream fos = new FileOutputStream(newFile);
						FileInputStream fis = new FileInputStream(file)) {
					byte[] b = new byte[1024];
					while(fis.read(b)!= -1) {
						fos. write(b);
					}
					System.out.println("文件:"+infos[1]+ "复制成功，副本文件是:"+ infos[2]);
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
					

			



			

			

			
    	
	   
	    
	

	

		

		
