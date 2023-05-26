package entity;


import java.io.Serializable;
import java.util.List;
import pojo.Book;

/**
 * 分页结果的实体类
 */
public class PageResult implements Serializable{
	private long total; // 总数
	private List<Book> rows; // 返回的数据集合
	
	public PageResult(long total, List<Book> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<Book> getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
}
