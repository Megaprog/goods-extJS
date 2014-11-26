package goods.model;

import javax.persistence.*;

@Entity
@Table(name = "goods")
@NamedQueries({
        @NamedQuery(name = "GoodsAll", query = "select g from Goods g"),
        @NamedQuery(name = "GoodsByName", query = "select g from Goods g where g.name like :name"),
        @NamedQuery(name = "GoodsByNamePrice", query = "select g from Goods g where g.name = :name and g.price = :price")
})
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

}
