package com.example.practicum12;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.UUID;

public class TicketDetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private TicketDetailFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private TicketDetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TicketDetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    TicketDetailFragmentArgs __result = new TicketDetailFragmentArgs();
    bundle.setClassLoader(TicketDetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("ticketId")) {
      UUID ticketId;
      if (Parcelable.class.isAssignableFrom(UUID.class) || Serializable.class.isAssignableFrom(UUID.class)) {
        ticketId = (UUID) bundle.get("ticketId");
      } else {
        throw new UnsupportedOperationException(UUID.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (ticketId == null) {
        throw new IllegalArgumentException("Argument \"ticketId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("ticketId", ticketId);
    } else {
      throw new IllegalArgumentException("Required argument \"ticketId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static TicketDetailFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    TicketDetailFragmentArgs __result = new TicketDetailFragmentArgs();
    if (savedStateHandle.contains("ticketId")) {
      UUID ticketId;
      ticketId = savedStateHandle.get("ticketId");
      if (ticketId == null) {
        throw new IllegalArgumentException("Argument \"ticketId\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("ticketId", ticketId);
    } else {
      throw new IllegalArgumentException("Required argument \"ticketId\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public UUID getTicketId() {
    return (UUID) arguments.get("ticketId");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("ticketId")) {
      UUID ticketId = (UUID) arguments.get("ticketId");
      if (Parcelable.class.isAssignableFrom(UUID.class) || ticketId == null) {
        __result.set("ticketId", Parcelable.class.cast(ticketId));
      } else if (Serializable.class.isAssignableFrom(UUID.class)) {
        __result.set("ticketId", Serializable.class.cast(ticketId));
      } else {
        throw new UnsupportedOperationException(UUID.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    TicketDetailFragmentArgs that = (TicketDetailFragmentArgs) object;
    if (arguments.containsKey("ticketId") != that.arguments.containsKey("ticketId")) {
      return false;
    }
    if (getTicketId() != null ? !getTicketId().equals(that.getTicketId()) : that.getTicketId() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getTicketId() != null ? getTicketId().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "TicketDetailFragmentArgs{"
        + "ticketId=" + getTicketId()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull TicketDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull UUID ticketId) {
      if (ticketId == null) {
        throw new IllegalArgumentException("Argument \"ticketId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("ticketId", ticketId);
    }

    @NonNull
    public TicketDetailFragmentArgs build() {
      TicketDetailFragmentArgs result = new TicketDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setTicketId(@NonNull UUID ticketId) {
      if (ticketId == null) {
        throw new IllegalArgumentException("Argument \"ticketId\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("ticketId", ticketId);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public UUID getTicketId() {
      return (UUID) arguments.get("ticketId");
    }
  }
}
