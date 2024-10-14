package com.example.practicum12;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.UUID;

public class TicketListFragmentDirections {
  private TicketListFragmentDirections() {
  }

  @NonNull
  public static ShowTicketDetail showTicketDetail(@NonNull UUID ticketId) {
    return new ShowTicketDetail(ticketId);
  }

  public static class ShowTicketDetail implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ShowTicketDetail(@NonNull UUID ticketId) {
      if (ticketId == null) {
        throw new IllegalArgumentException("Argument \"ticketId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("ticketId", ticketId);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ShowTicketDetail setTicketId(@NonNull UUID ticketId) {
      if (ticketId == null) {
        throw new IllegalArgumentException("Argument \"ticketId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("ticketId", ticketId);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("ticketId")) {
        UUID ticketId = (UUID) arguments.get("ticketId");
        if (Parcelable.class.isAssignableFrom(UUID.class) || ticketId == null) {
          __result.putParcelable("ticketId", Parcelable.class.cast(ticketId));
        } else if (Serializable.class.isAssignableFrom(UUID.class)) {
          __result.putSerializable("ticketId", Serializable.class.cast(ticketId));
        } else {
          throw new UnsupportedOperationException(UUID.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.show_ticket_detail;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public UUID getTicketId() {
      return (UUID) arguments.get("ticketId");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ShowTicketDetail that = (ShowTicketDetail) object;
      if (arguments.containsKey("ticketId") != that.arguments.containsKey("ticketId")) {
        return false;
      }
      if (getTicketId() != null ? !getTicketId().equals(that.getTicketId()) : that.getTicketId() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getTicketId() != null ? getTicketId().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ShowTicketDetail(actionId=" + getActionId() + "){"
          + "ticketId=" + getTicketId()
          + "}";
    }
  }
}
