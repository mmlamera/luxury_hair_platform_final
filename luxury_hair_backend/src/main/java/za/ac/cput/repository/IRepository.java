package za.ac.cput.repository;

import java.util.List;

@Deprecated
public interface IRepository <P, PID> {
    P create(P p);
    P read(PID id);
    P update(P p);

    boolean delete(PID id);
    List<P> getAll();
}
