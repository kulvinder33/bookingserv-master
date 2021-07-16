
package com.paypal.bfs.test.bookingserv.api.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "checkin",
    "checkout",
    "total_price",
    "deposit",
    "address"
})
@Generated("jsonschema2pojo")
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    @Size(min = 1, max = 255)
    @NotNull
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    @Size(min = 1, max = 255)
    @NotNull
    private String lastName;
    /**
     * Date Of Birth
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("Date Of Birth")
    @NotNull
    private Date dateOfBirth;
    /**
     * Check In
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @JsonProperty("checkin")
    @JsonPropertyDescription("Check In")
    @NotNull
    private Date checkin;
    /**
     * Checkout
     * (Required)
     * 
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @JsonProperty("checkout")
    @JsonPropertyDescription("Checkout")
    @NotNull
    private Date checkout;
    /**
     * Total Price Amount
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total Price Amount")
    @NotNull
    private Integer totalPrice;
    /**
     * Deposited Amount
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposited Amount")
    @NotNull
    private Integer deposit;
    /**
     * Address
     * (Required)
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("Address")
    @Valid
    @NotNull
    private Address address;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Date Of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date Of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Check In
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    public Date getCheckin() {
        return checkin;
    }

    /**
     * Check In
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    /**
     * Checkout
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    public Date getCheckout() {
        return checkout;
    }

    /**
     * Checkout
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    /**
     * Total Price Amount
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total Price Amount
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Deposited Amount
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public Integer getDeposit() {
        return deposit;
    }

    /**
     * Deposited Amount
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    /**
     * Address
     * (Required)
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Address
     * (Required)
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("checkin");
        sb.append('=');
        sb.append(((this.checkin == null)?"<null>":this.checkin));
        sb.append(',');
        sb.append("checkout");
        sb.append('=');
        sb.append(((this.checkout == null)?"<null>":this.checkout));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
