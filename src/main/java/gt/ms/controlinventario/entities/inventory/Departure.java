/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.ms.controlinventario.entities.inventory;

import gt.ms.controlinventario.base.FullyAuditedEntity;
import gt.ms.controlinventario.entities.rrhh.Person;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;

/**
 *
 * @author Steven
 */
@Entity()
@Table(schema = "inventory")
@Audited()
public class Departure extends FullyAuditedEntity {

    @Temporal(TemporalType.DATE)
    private Date departureDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Entry entry;
    
    private Integer quantity;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn()
    private Person responsable;
    
    private Integer ticket;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private DepartureType departureType;
    
    private String reason;
    
    private String observation;

    public Departure() {
    }

    public Departure(Date departureDate, Entry entry, Integer quantity, Person responsable, Integer ticket, DepartureType departureType, String reason, String observation) {
        this.departureDate = departureDate;
        this.entry = entry;
        this.quantity = quantity;
        this.responsable = responsable;
        this.ticket = ticket;
        this.departureType = departureType;
        this.reason = reason;
        this.observation = observation;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Person getResponsable() {
        return responsable;
    }

    public void setResponsable(Person responsable) {
        this.responsable = responsable;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public DepartureType getDepartureType() {
        return departureType;
    }

    public void setDepartureType(DepartureType departureType) {
        this.departureType = departureType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Departure{" + "departureDate=" + departureDate + ", entry=" + entry + ", quantity=" + quantity + ", responsable=" + responsable + ", ticket=" + ticket + ", departureType=" + departureType + ", reason=" + reason + ", observation=" + observation + '}';
    }
    
}