import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOcontrol
{

	public static void main(String[] args) throws IOException
	{
		new creatFile().creatFile();
		new deleteFile().deleteFile();

		System.out.println("文件创建完成");

	}

	public static class creatFile
	{
		public File file1;

		public void creatFile() throws IOException
		{
			System.out.println("请输入文件地址:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String fileadress = br.readLine();
			File file = new File(fileadress);
			if (!file.exists())
			{
				file.mkdir();
			}
			System.out.println("请输入文件名");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
			String filename = br1.readLine();
			File file1 = new File(fileadress, filename);
			if (!file1.exists())
			{
				file1.createNewFile();
			}
			System.out.println("请输入文件内容：");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String content = br2.readLine();
			// jdk7 创建文件新方法
			FileOutputStream fop = new FileOutputStream(file1);
			byte[] byteinContent = content.getBytes();
			fop.write(byteinContent);
			fop.flush();
			fop.close();
		}
	}

	public static class deleteFile extends creatFile
	{
		public void deleteFile() throws IOException
		{
			System.out.println("是否删除文件：yes(y)or no(n)");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
			String choose = br3.readLine();

			if ("y" == choose)
			{
				System.out.println("1");
				
				file1.delete();
			} else if ("n" == choose)
			{
				return;
			}
		}
	}

}
