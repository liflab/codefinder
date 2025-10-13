/*
    Analysis of assertions in Java programs
    Copyright (C) 2025 Sylvain Hallé, Sarika Machhindra Kadam

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.uqac.lif.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Print stream with facilities for producing colored text using ANSI escape
 * codes.
 * 
 * @author sylvain
 */
public class AnsiPrinter extends PrintStream
{
	/**
	 * Default 16-color scheme for foreground and background text
	 */
	public static enum Color
	{
		BLACK, BLUE, GREEN, CYAN, RED, PURPLE, BROWN, LIGHT_GRAY, DARK_GRAY, LIGHT_BLUE, LIGHT_GREEN, LIGHT_CYAN, LIGHT_RED, LIGHT_PURPLE, YELLOW, WHITE
	};

	/**
	 * Whether ANSI codes are enabled. If set to false (with
	 * {@link #disableColors()}), behaves like a normal PrintStream
	 */
	protected boolean m_enabled = true;

	/**
	 * Instantiates an AnsiPrinter.
	 * 
	 * @param out
	 *          The OutputStream where the printer will send its output
	 */
	public AnsiPrinter(OutputStream out)
	{
		super(out);
	}

	/**
	 * A reader from the standard input
	 */
	private final BufferedReader m_console = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Enables the output of ANSI codes in the output stream
	 */
	public AnsiPrinter enableColors()
	{
		m_enabled = true;
		return this;
	}

	/**
	 * Disables the output of ANSI codes in the output stream
	 */
	public AnsiPrinter disableColors()
	{
		m_enabled = false;
		return this;
	}
	
	/**
	 * Same as {@link #print(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter put(Object o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #print(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter put(int o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #print(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter put(String o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #print(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter put(long o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #print(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter put(double o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #print(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter put(float o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #println(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter putln(Object o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #println(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter putln(int o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #println(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter putln(String o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #println(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter putln(long o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #println(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter putln(double o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Same as {@link #println(Object)}, but returns the printer.
	 * @param o The thing to print
	 * @return This printer
	 */
	public AnsiPrinter putln(float o)
	{
		print(o);
		return this;
	}
	
	/**
	 * Prints a SIXEL image to the output stream. The SIXEL data must be provided as a
	 * string, presumably produced from an image conversion tool.
	 * like <tt>img2sixel</tt>.
	 * @param sixelData The SIXEL data
	 * @return This printer
	 */
	public AnsiPrinter printSixel(String sixelData)
	{
		if (!m_enabled)
			return this;
		print("\u001B[P");
		print(sixelData);
		print("\u001B\\");
		return this;
	}

	/**
	 * Sets the foreground color for printed text. Until this color is changed, the
	 * text will be printed using that color.
	 * 
	 * @param c
	 *          The color
	 * @return This printer
	 */
	public AnsiPrinter setForegroundColor(AnsiPrinter.Color c)
	{
		if (!m_enabled)
		{
			return this;
		}
		String to_print = "";
		switch (c)
		{
		case BLACK:
			to_print = "\u001B[2;30m";
			break;
		case RED:
			to_print = "\u001B[2;31m";
			break;
		case GREEN:
			to_print = "\u001B[2;32m";
			break;
		case BROWN:
			to_print = "\u001B[2;33m";
			break;
		case BLUE:
			to_print = "\u001B[2;34m";
			break;
		case PURPLE:
			to_print = "\u001B[2;35m";
			break;
		case CYAN:
			to_print = "\u001B[2;36m";
			break;
		case LIGHT_GRAY:
			to_print = "\u001B[2;37m";
			break;
		case DARK_GRAY:
			to_print = "\u001B[1;30m";
			break;
		case LIGHT_RED:
			to_print = "\u001B[1;31m";
			break;
		case LIGHT_GREEN:
			to_print = "\u001B[1;32m";
			break;
		case YELLOW:
			to_print = "\u001B[1;33m";
			break;
		case LIGHT_BLUE:
			to_print = "\u001B[1;34m";
			break;
		case LIGHT_PURPLE:
			to_print = "\u001B[1;35m";
			break;
		case LIGHT_CYAN:
			to_print = "\u001B[1;36m";
			break;
		case WHITE:
			to_print = "\u001B[1;37m";
			break;
		default:
			// Do nothing
			break;
		}
		printBytes(to_print);
		return this;
	}

	/**
	 * Shortcut to {@link #setForegroundColor(Color)}.
	 * 
	 * @param c
	 *          The colour
	 * @return This printer
	 */
	public AnsiPrinter fg(Color c)
	{
		return setForegroundColor(c);
	}
	
	/**
	 * Sets the text to italics.
	 * @return This printer
	 */
	public AnsiPrinter italics()
	{
		if (m_enabled)
			printBytes("\u001B[3m");
		return this;
	}
	
	/**
	 * Stops italics.
	 * @return This printer
	 */
	public AnsiPrinter unitalics()
	{
		if (m_enabled)
			printBytes("\u001B[23m");
		return this;
	}

	/**
	 * Sets the foreground color based on its RGB components.
	 * 
	 * @param r
	 *          The amount of red (R), between 0 and 255
	 * @param g
	 *          The amount of green (G), between 0 and 255
	 * @param b
	 *          The amount of blue (B), between 0 and 255
	 * @return This printer
	 */
	public AnsiPrinter setForegroundColor(int r, int g, int b)
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[38;2;" + r + ";" + g + ";" + b + "m");
		return this;
	}

	/**
	 * Sets the background color for printed text. Until this color is changed, the
	 * text will be printed using that color.
	 * 
	 * @param c
	 *          The color
	 * @return This printer
	 */
	public AnsiPrinter setBackgroundColor(AnsiPrinter.Color c)
	{
		if (!m_enabled)
		{
			return this;
		}
		String to_print = "";
		switch (c)
		{
		case BLACK:
			to_print = "\u001B[2;40m";
			break;
		case RED:
			to_print = "\u001B[2;41m";
			break;
		case GREEN:
			to_print = "\u001B[2;42m";
			break;
		case BROWN:
			to_print = "\u001B[2;43m";
			break;
		case BLUE:
			to_print = "\u001B[2;44m";
			break;
		case PURPLE:
			to_print = "\u001B[2;45m";
			break;
		case CYAN:
			to_print = "\u001B[2;46m";
			break;
		case LIGHT_GRAY:
			to_print = "\u001B[2;47m";
			break;
		case DARK_GRAY:
			to_print = "\u001B[1;40m";
			break;
		case LIGHT_RED:
			to_print = "\u001B[1;41m";
			break;
		case LIGHT_GREEN:
			to_print = "\u001B[1;42m";
			break;
		case YELLOW:
			to_print = "\u001B[1;43m";
			break;
		case LIGHT_BLUE:
			to_print = "\u001B[1;44m";
			break;
		case LIGHT_PURPLE:
			to_print = "\u001B[1;45m";
			break;
		case LIGHT_CYAN:
			to_print = "\u001B[1;46m";
			break;
		case WHITE:
			to_print = "\u001B[1;47m";
			break;
		default:
			// Do nothing
			break;
		}
		printBytes(to_print);
		return this;
	}

	/**
	 * Shortcut to {@link #setBackgroundColor(Color)}.
	 * 
	 * @param c
	 *          The colour
	 * @return This printer
	 */
	public AnsiPrinter bg(Color c)
	{
		return setBackgroundColor(c);
	}

	/**
	 * Sets the background color based on its RGB components.
	 * 
	 * @param r
	 *          The amount of red (R), between 0 and 255
	 * @param g
	 *          The amount of green (G), between 0 and 255
	 * @param b
	 *          The amount of blue (B), between 0 and 255
	 * @return This printer
	 */
	public AnsiPrinter setBackgroundColor(int r, int g, int b)
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[48;2;" + r + ";" + g + ";" + b + "m");
		return this;
	}

	/**
	 * Resets the colors to their default values
	 * 
	 * @return This printer
	 */
	public AnsiPrinter resetColors()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[0m");
		printBytes("\u001B[39m");
		printBytes("\u001B[49m");
		return this;
	}

	public AnsiPrinter setUnderscore()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[4m");
		return this;
	}

	/**
	 * Prints a string to bytes
	 * 
	 * @param s
	 *          The string to print
	 */
	public void printBytes(String s)
	{
		try
		{
			out.write(s.getBytes());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Trims a string to a certain number of lines. This method is used to limit the
	 * size of code snippets in the output.
	 * 
	 * @param s
	 *          The string to trim
	 * @param num_lines
	 *          The maximum number of lines to keep
	 * @return The trimmed string
	 */
	public static String trimLines(String s, int num_lines)
	{
		StringBuilder out = new StringBuilder();
		String[] lines = s.split("\\n");
		for (int i = 0; i < Math.min(lines.length, num_lines); i++)
		{
			out.append(lines[i]).append("\n");
		}
		return out.toString();
	}

	/**
	 * Pads a string with spaces to a certain length. If the string is longer than
	 * the specified length, it is truncated.
	 * 
	 * @param s
	 *          The string to pad
	 * @param length
	 *          The target length
	 * @return The padded (or truncated) string
	 */
	public static String padToLength(String s, int length)
	{
		return padToLength(s, length, false);
	}

	/**
	 * Pads a string with a character to a certain length. If the string is longer than
	 * the specified length, it is truncated. If the parameter <tt>dots</tt> is
	 * true, an ellipsis character ("...") is added at the end of the truncated
	 * string.
	 * 
	 * @param s
	 *          The string to pad
	 * @param c
	 *          The padding character
	 * @param length
	 *          The target length
	 * @param dots
	 *          If true, adds "..." at the end of the string if it is truncated
	 * @return The padded (or truncated) string
	 */
	public static String padToLength(String s, String c, int length, boolean dots)
	{
		if (s == null)
		{
			s = "";
		}
		int str_len = s.length();
		if (str_len == length)
		{
			return s;
		}
		if (str_len > length)
		{
			return s.substring(0, length - (dots ? 1 : 0)) + (dots ? "\u2026" : "");
		}
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		for (int i = str_len; i < length; i++)
		{
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * Pads a string with spaces to a certain length. If the string is longer than
	 * the specified length, it is truncated. If the parameter <tt>dots</tt> is
	 * true, an ellipsis character ("...") is added at the end of the truncated
	 * string.
	 * 
	 * @param s
	 *          The string to pad
	 * @param length
	 *          The target length
	 * @param dots
	 *          If true, adds "..." at the end of the string if it is truncated
	 * @return The padded (or truncated) string
	 */
	public static String padToLength(String s, int length, boolean dots)
	{
		return padToLength(s, " ", length, dots);
	}

	/**
	 * Reads a line from the standard input
	 * 
	 * @return The line
	 */
	public String readLine()
	{
		try
		{
			return m_console.readLine();
		}
		catch (IOException e)
		{
			Logger.getAnonymousLogger().log(Level.WARNING, e.getMessage());
		}
		return "";
	}

	/**
	 * Determines if the display of colours is enabled
	 * 
	 * @return true if colors enabled, false otherwise
	 */
	public boolean colorsEnabled()
	{
		return m_enabled;
	}

	/**
	 * Sets the text to boldface.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter bold()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[1m");
		return this;
	}

	/**
	 * Sets the text to normal weight (not boldface).
	 * 
	 * @return This printer
	 */
	public AnsiPrinter unbold()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[22m");
		return this;
	}

	/**
	 * Underlines the text.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter underline()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[4m");
		return this;
	}

	/**
	 * Stops underlining the text.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter ununderline()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[24m");
		return this;
	}

	/**
	 * Sets the text to reverse video (swaps foreground and background colors).
	 * 
	 * @return This printer
	 */
	public AnsiPrinter reverseVideo()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[7m");
		return this;
	}

	/**
	 * Stops reverse video.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter unreverseVideo()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[27m");
		return this;
	}

	/**
	 * Clears the screen and moves the cursor to the top left corner.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter clearScreen()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[2J");
		printBytes("\u001B[H");
		return this;
	}

	/**
	 * Moves the cursor to the start of the last line of the console.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter moveStartLastLine()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[1F");
		return this;
	}

	/**
	 * Moves the cursor to the beginning of the current line.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter moveBeginningLine()
	{
		if (!m_enabled)
			return this;
		printBytes("\r");
		return this;
	}

	/**
	 * Clears the current line.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter clearLine()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[2K");
		return this;
	}

	/**
	 * Hides the cursor.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter hideCursor()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[?25h");
		return this;
	}

	/**
	 * Shows the cursor.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter showCursor()
	{
		if (!m_enabled)
			return this;
		printBytes("\u001B[?25l");
		return this;
	}

	/**
	 * Sets the color scheme to white text on black background.
	 * 
	 * @return This printer
	 */
	public AnsiPrinter setWhiteOnBlack()
	{
		resetColors();
		setBackgroundColor(Color.BLACK);
		setForegroundColor(Color.LIGHT_GRAY);
		return this;
	}

	/**
	 * Formats a duration in milliseconds into a human-readable string.
	 * 
	 * @param duration
	 *          The duration in milliseconds
	 * @return A human-readable string representing the duration
	 */
	public static String formatDuration(long duration)
	{
		if (duration < 1000)
		{
			return duration + " ms";
		}
		else if (duration < 60000)
		{
			return (duration / 1000) + " s";
		}
		else
		{
			long minutes = duration / 60000;
			long seconds = (duration % 60000) / 1000;
			return minutes + " min " + seconds + " s";
		}
	}

	/**
	 * Formats a duration in milliseconds into a string of the form HH:MM:SS.
	 * 
	 * @param duration
	 *          The duration in milliseconds
	 * @return A string of the form HH:MM:SS
	 */
	public static String formatHms(long duration)
	{
		long hours = duration / 3600000;
		long minutes = (duration % 3600000) / 60000;
		long seconds = (duration % 60000) / 1000;
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

}