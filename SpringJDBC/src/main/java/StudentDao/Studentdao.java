package StudentDao;

import java.util.List;

public interface Studentdao {
public int insert(StudentBean s);
public int update(StudentBean s);
public int delete(StudentBean s);
public List<StudentBean> fetch(StudentBean s);

public StudentBean fetchbyRowMapper(StudentBean s);
public List<StudentBean> fetchmultiObjectByRowMapper(StudentBean s);
}
