package com.conygre.spring.boot.entities;

        import java.io.Serializable;
        import java.util.ArrayList;
        import java.util.List;

        import javax.persistence.*;


// add an annotations specifying the table that this will map to
@Entity
@Table(name="stocks")

// Adding caching
//@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//@Cacheable

// ensure that the class implements Serializable

//@NamedQueries(
//        {
//                @NamedQuery(name="compactdisc.getAll", ?
//                        query="select cd from CompactDisc as cd where cd.price > :price", ?
//                        hints = {@QueryHint(name = "org.hibernate.cacheable", value = "true")})
//        })



public class Stock implements Serializable {


    // add an attribute specifying a column for the id property
    // add attributes to ensure that the id column is automantically generated
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;




    @Column(name="ticker") private String ticker;

    @Column(name="price") private Double price;
    @Column(name="amount") private Integer amount;
    @Column(name="transaction_type") private String transaction_type; //

    public Stock() {}

    public Stock(Integer id, String ticker, Double price, Integer amount, String transaction_type){
        this.id = id;
        this.ticker = ticker;
        this.price = price;
        this.amount = amount;
        this.transaction_type = transaction_type;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transaction_type;
    }

    public void setTransactionType(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    // Adding relationships
//    @JoinColumn(name="cd_id", referencedColumnName="id")
//    @OneToMany( cascade={CascadeType.MERGE, CascadeType.PERSIST})
//    private List<Track> trackTitles = new ArrayList<Track>();
//
//    public List<Track> getTrackTitles() {
//        return trackTitles;
//    }
//
//    public void setTrackTitles(List<Track> trackTitles) {
//        this.trackTitles = trackTitles;
//    }



}



